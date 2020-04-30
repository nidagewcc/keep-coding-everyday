package com.interview.datacollect.task;

import com.interview.datacollect.service.CollectService;
import org.hyperic.sigar.SigarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CollectTask {

    /**
     * 执行频率 每分钟（每60s）
     */
    private static final int EXEC_FREQ = 60 * 1000;

    @Autowired
    private CollectService collectService;

    @Scheduled(fixedRate = EXEC_FREQ)
    public void cpuCollect() throws SigarException {
        collectService.collectCpuUsage();
    }

    @Scheduled(fixedRate = EXEC_FREQ)
    public void memoryCollect() throws SigarException {
        collectService.collectMemUsage();
    }

    @Scheduled(fixedRate = EXEC_FREQ)
    public void diskCollect() throws SigarException {
        collectService.collectDiskUsage();
    }

    @Scheduled(fixedRate = EXEC_FREQ)
    public void netCollect() throws InterruptedException, SigarException {
        collectService.collectNetTrans();
    }
}
