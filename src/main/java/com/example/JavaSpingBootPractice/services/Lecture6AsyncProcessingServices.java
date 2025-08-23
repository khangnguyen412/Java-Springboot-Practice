package com.example.JavaSpingBootPractice.services;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

@Service
public class Lecture6AsyncProcessingServices {

    @Async("taskExecutor") // chỉ định pool
    public void send_email(String to) {
        System.out.println("Send email to " + to + " | Thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Email sent to " + to);
    }

    @Async
    public CompletableFuture<String> generate_report() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture("Report generated");
    }

    // chạy mỗi 5 giây
    @Scheduled(fixedRate = 5000)
    public void schedule_task() {
        System.out.println("[" + new Date() + "] " + "Schedule task | Thread: " + Thread.currentThread().getName());
    }

    // chạy theo cron: 10h sáng mỗi ngày
    @Scheduled(cron = "0 0 10 * * ?")
    public void dailyJob() {
        System.out.println("Running daily job...");
    }
}
