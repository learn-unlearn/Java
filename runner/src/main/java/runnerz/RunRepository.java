package runnerz;

import jakarta.annotation.PostConstruct;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.springframework.stereotype.Component;

//@Component
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll () {
        return runs;
    }

    Optional<Run> findById (Integer id) {
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }

    void store (Run run) {
        runs.add(run);
    }

    void update (Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete (Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    private void init () {
        runs.add(new Run(1, "Wednesday Run", LocalDateTime.now(), LocalDateTime.now().plus(30, ChronoUnit.MINUTES), 5, Location.OUTDOOR));
        runs.add(new Run(1, "Thursday Run", LocalDateTime.now().plus(1, ChronoUnit.DAYS), LocalDateTime.now().plus(30, ChronoUnit.MINUTES), 5, Location.OUTDOOR));
    }
}
