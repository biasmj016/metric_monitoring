package com.biasmj.monitor.adapter.api;

import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiController {

    @Timed(value = "api.response.time", description = "API 응답 시간")
    @GetMapping("/api/monitor")
    public String monitor() {
        return "Monitoring data";
    }
}