package io.runner.runner.run;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        String title,
        LocalDateTime start_time,
        LocalDateTime end_time,
        Integer miles,
        Location location) {

    public Run {
        if (!end_time.isAfter(start_time)) {
            throw new IllegalArgumentException("You cannot stop before you start");
        }
    }
}
