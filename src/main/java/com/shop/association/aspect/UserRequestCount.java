package com.shop.association.aspect;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class UserRequestCount {

    private final Integer count;

    private final LocalDateTime lastRequestTime;

    public long timeToWait() {
        Duration duration = Duration.between(lastRequestTime, LocalDateTime.now());
        if (duration.toMinutes() < 15) {
            return 15 - duration.toMinutes();
        }
        return 0;
    }

}
