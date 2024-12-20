package runnerz;

import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RestController
//@RequestMapping("/api/runs")
public class RunController {

//    private final RunRepository runRepository;
//    @Autowired
    private RunRepository runRepository;

//    public RunController (RunRepository repository) {
//        this.runRepository = repository;
//    }

    @GetMapping("")
    List<Run> index () {
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    public Run show(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()) {
            throw new RunNotFoundException();
        }
        return run.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void store (@Valid @RequestBody Run run) {
        runRepository.store(run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update (@RequestBody Run run,@PathVariable Integer id) {
        runRepository.update(run, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void destroy (@PathVariable Integer id) {
        runRepository.delete(id);
    }
}
