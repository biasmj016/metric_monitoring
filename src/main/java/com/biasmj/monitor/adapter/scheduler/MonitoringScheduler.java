package com.biasmj.monitor.adapter.scheduler;

import com.biasmj.monitor.application.service.EmailNotifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

@Component
public class MonitoringScheduler {
    private static final Logger logger = LoggerFactory.getLogger(MonitoringScheduler.class);
    private final EmailNotifier emailNotifier;

    @Value("${monitoring.cpu.threshold}")
    private double cpuThreshold;

    public MonitoringScheduler(EmailNotifier emailNotifier) {
        this.emailNotifier = emailNotifier;
    }

    @Scheduled(fixedRate = 60000)
    public void monitor() {
        if (checkCpuUsage()) emailNotifier.execute();
    }

    private boolean checkCpuUsage() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        double cpuLoad = osBean.getSystemLoadAverage();
        logger.info("Current CPU load: {}", cpuLoad);

        return cpuLoad > cpuThreshold;
    }
}