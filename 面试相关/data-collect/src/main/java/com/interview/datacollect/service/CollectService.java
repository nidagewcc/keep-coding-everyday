package com.interview.datacollect.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.interview.datacollect.mapper.CpuMapper;
import com.interview.datacollect.mapper.DiskMapper;
import com.interview.datacollect.mapper.MemoryMapper;
import com.interview.datacollect.mapper.NetMapper;
import com.interview.datacollect.pojo.*;
import com.interview.datacollect.pojo.Cpu;
import org.hyperic.sigar.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollectService {

    @Autowired
    private CpuMapper cpuMapper;
    @Autowired
    private MemoryMapper memoryMapper;
    @Autowired
    private DiskMapper diskMapper;
    @Autowired
    private NetMapper netMapper;

    /**
     * 获取CPU利用率
     */
    public void collectCpuUsage() throws SigarException {
        Sigar sigar = new Sigar();
        BigDecimal cupUsage = new BigDecimal(CpuPerc.format(sigar.getCpuPercList()[0].getCombined()).replace("%", ""));

        Cpu cpu = new Cpu();
        cpu.setCpuUsage(cupUsage);
        cpuMapper.insert(cpu);
    }

    /**
     * 内存使用率
     *
     * @throws SigarException
     */
    public void collectMemUsage() throws SigarException {
        Sigar sigar = new Sigar();
        Mem mem = sigar.getMem();
        long total = mem.getTotal();
        long used = mem.getUsed();
        BigDecimal memUsage = BigDecimal.valueOf(used).divide(BigDecimal.valueOf(total), 2, RoundingMode.HALF_UP);
        System.out.printf("总内存：%d，使用内存：%d，内存使用率：%s \r\n", total, used, memUsage);

        Memory memory = new Memory();
        memory.setMemUsage(memUsage);
        memoryMapper.insert(memory);
    }

    /**
     * 磁盘使用
     *
     * @throws SigarException
     */
    public void collectDiskUsage() throws SigarException {
        Sigar sigar = new Sigar();

        // win环境暂时用C盘测试数据，以C盘为例
        FileSystemUsage fileSystemUsage = sigar.getFileSystemUsage("C:\\");
        // Linux下获取跟目录 \
        // FileSystemUsage fileSystemUsage = sigar.getFileSystemUsage("\\");
        long total1 = fileSystemUsage.getTotal();
        long used1 = fileSystemUsage.getUsed();
        BigDecimal diskUsage = BigDecimal.valueOf(used1).divide(BigDecimal.valueOf(total1), 2, RoundingMode.HALF_UP);

        System.out.printf("磁盘总容量：%d，已使用容量：%d，磁盘使用率：%s", total1, used1, diskUsage);

        Disk disk = new Disk();
        disk.setDiskUsage(diskUsage);
        diskMapper.insert(disk);
    }

    /**
     * 网卡传输速率
     */
    public void collectNetTrans() throws SigarException, InterruptedException {

        Sigar sigar = new Sigar();
        String[] netInterfaceList = sigar.getNetInterfaceList();
        BigDecimal rx = BigDecimal.ZERO;
        BigDecimal tx = BigDecimal.ZERO;
        for (String s : netInterfaceList) {
            NetInterfaceStat netInterfaceStat = sigar.getNetInterfaceStat(s);
            long rxBytes = netInterfaceStat.getRxBytes();
            long txBytes = netInterfaceStat.getTxBytes();

            rx = rx.add(BigDecimal.valueOf(rxBytes).divide(new BigDecimal(1024L), 0, RoundingMode.HALF_UP));
            tx = tx.add(BigDecimal.valueOf(txBytes).divide(new BigDecimal(1024L), 0, RoundingMode.HALF_UP));
        }

        System.out.println("第一次获取所有网卡传输字节, rx：" + rx + "; tx：" + tx);

        // 网卡传输速率只能通过两个时间点传输的字节数的差值/时间得出，故可以先sleep 5s
        Thread.sleep(5000);

        String[] netInterfaceList1 = sigar.getNetInterfaceList();
        BigDecimal rx1 = BigDecimal.ZERO;
        BigDecimal tx1 = BigDecimal.ZERO;
        for (String s : netInterfaceList1) {
            NetInterfaceStat netInterfaceStat = sigar.getNetInterfaceStat(s);
            long rxBytes = netInterfaceStat.getRxBytes();
            long txBytes = netInterfaceStat.getTxBytes();

            rx1 = rx1.add(BigDecimal.valueOf(rxBytes).divide(new BigDecimal(1024L), 0, RoundingMode.HALF_UP));
            tx1 = tx1.add(BigDecimal.valueOf(txBytes).divide(new BigDecimal(1024L), 0, RoundingMode.HALF_UP));
        }

        System.out.println("第二次获取所有网卡传输字节, rx1：" + rx1 + "; tx1：" + tx1);

        // rx的传输速率
        BigDecimal rxv = rx1.subtract(rx).divide(BigDecimal.valueOf(5), 0, RoundingMode.HALF_UP);
        System.out.println("rx速率：" + rxv);
        // tx的传输速率
        BigDecimal txv = tx1.subtract(tx).divide(BigDecimal.valueOf(5), 0, RoundingMode.HALF_UP);
        System.out.println("tx速率：" + txv);

        // 入库
        Net net = new Net();
        net.setRx(rxv.intValue());
        net.setTx(txv.intValue());
        netMapper.insert(net);
    }

    /**
     * 查询cpu、内存、硬盘、网络
     *
     * @return
     */
    public Map<String, Object> getCollectData() {

        Map<String, Object> retMap = new HashMap<>();

        List<Cpu> cpus = this.listCpu();
        retMap.put("cpus", cpus);

        List<Memory> memories = this.listMem();
        retMap.put("memories", memories);

        List<Disk> disks = this.listDisk();
        retMap.put("disks", disks);

        List<Net> nets = this.listNet();
        retMap.put("nets", nets);

        return retMap;
    }

    private List<Cpu> listCpu() {

        PageHelper.startPage(0, 10);

        // 查询cpu
        CpuExample cpuExample = new CpuExample();
        cpuExample.setOrderByClause("collect_time DESC");
        List<Cpu> cpus = cpuMapper.selectByExample(cpuExample);
        // 反转list
        Collections.reverse(cpus);
        return cpus;
    }

    private List<Memory> listMem() {
        PageHelper.startPage(0, 10);

        MemoryExample example = new MemoryExample();
        example.setOrderByClause("collect_time DESC");
        List<Memory> memories = memoryMapper.selectByExample(example);

        Collections.reverse(memories);
        return memories;
    }

    private List<Disk> listDisk() {
        PageHelper.startPage(0, 10);

        DiskExample example = new DiskExample();
        example.setOrderByClause("collect_time DESC");
        List<Disk> disks = diskMapper.selectByExample(example);
        Collections.reverse(disks);

        return disks;
    }

    private List<Net> listNet() {
        PageHelper.startPage(0, 10);

        NetExample example = new NetExample();
        example.setOrderByClause("Collect_time DESC");
        List<Net> nets = netMapper.selectByExample(example);

        Collections.reverse(nets);
        return nets;
    }
}
