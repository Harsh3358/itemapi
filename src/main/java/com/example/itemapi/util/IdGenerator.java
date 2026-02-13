package com.example.itemapi.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class IdGenerator {

    // Thread-safe ID generation --> Multiple users can create items safely.
    private final AtomicLong counter = new AtomicLong(1);

    public Long nextId() {
        return counter.getAndIncrement();
    }
}
