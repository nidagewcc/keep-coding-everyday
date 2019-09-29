# Linux 命令收集

- grep -o '关键词' 文件 | wc -l
> 例如：
> > 从文件all_ecej-pay-transfer-sap.log中找出Connect to message server host failed出现了多少次，就可以直接输入：
> > > grep -o 'Connect to message server host failed' all_ecej-pay-transfer-sap.log | wc -l