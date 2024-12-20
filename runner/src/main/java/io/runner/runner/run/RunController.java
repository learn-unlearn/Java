package io.runner.runner.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.runner.runner.run.RunnerRepository;

import java.util.List;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private static final Logger log = LoggerFactory.getLogger(RunController.class);
    private final RunnerRepository runRepository;

    public RunController (RunnerRepository repository) {
        this.runRepository = repository;
    }

    @GetMapping("")
    public List<Run> index () {
        log.info("Welcome here Bobo yiii");
        return runRepository.findAll();
    }
}
