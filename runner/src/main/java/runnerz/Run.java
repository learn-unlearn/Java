package runnerz;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location
) {
    public Run {
        if (completedOn != null && startedOn != null && !completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Completed time must be after the start time");
        }
    }
//    public Run () {
//        if (!completedOn.isAfter(startedOn)) {
//            throw new IllegalArgumentException("Completed Argument must be after Started on");
//        }
//    }
}