package com.interview.datacollect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 开启任务调度
public class DataCollectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataCollectApplication.class, args);
    }

}
