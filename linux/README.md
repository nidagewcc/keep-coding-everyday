# Linux 命令收集

---
- 查询指定关键词在某文件中出现了多少次
```
grep -o '关键词' 文件 | wc -l
```

> 例如：
>  从文件all_ecej-pay-transfer-sap.log中找出Connect to message server host failed出现了多少次，就可以直接输入：

```
 grep -o 'Connect to message server host failed' all_ecej-pay-transfer-sap.log | wc -l
```

---

-  查看磁盘剩余空间

```
df -hl
```

![image](https://github.com/nidagewcc/images/blob/master/linux_command1.png?raw=true)

- 查看指定目录大小

```
du -sh [指定目录/文件]
```
![image](https://github.com/nidagewcc/images/blob/master/linux_command2.png?raw=true)


---