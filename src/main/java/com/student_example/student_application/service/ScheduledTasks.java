package com.student_example.student_application.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private static String apply(String s) {
        return s + " World";
    }

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() throws ExecutionException, InterruptedException {
        log.info("First!The time is now {}", dateFormat.format(new Date()));
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() ->  {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        });

        CompletableFuture<String> future = completableFuture
                .thenApply(ScheduledTasks::apply);

        CompletableFuture<Void> futureFinal = future
                .thenRun(() -> {
                    log.info("The process has been finished: {}", dateFormat.format(new Date()));
                });

        log.info(future.get());
        List<CompletableFuture> futures = new ArrayList<CompletableFuture>();

        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "Hello";
            }
        };
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(supplier);
        futures.add(future1);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()->"Beautiful");
        futures.add(future2);
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(()->"World");
        futures.add(future3);
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
        combinedFuture.get();

        String combined = Stream.of(future1, future2, future3).map(CompletableFuture::join).collect(Collectors.joining(" "));
        log.info(combined);
    }
}