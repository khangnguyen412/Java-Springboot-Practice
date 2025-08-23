package com.example.JavaSpingBootPractice.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

public class CustomHealthCheck implements HealthIndicator {
    @Override
    public Health health() {
        boolean serverOk = true; // logic kiểm tra service bên ngoài
        if (serverOk) {
            return Health.up().withDetail("ExternalService", "Running").build();
        }
        return Health.down().withDetail("ExternalService", "Not Available").build();
    }
}
