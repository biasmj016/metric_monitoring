package com.biasmj.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MetricMonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetricMonitoringApplication.class, args);
    }

}
