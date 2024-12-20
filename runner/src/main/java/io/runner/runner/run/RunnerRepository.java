package io.runner.runner.run;

import java.util.ArrayList;
import java.util.List;

public class RunnerRepository {
    private List<Run> runs = new ArrayList<>();

    List<Run> findAll () {
        return runs;
    }
}
