package entityForPerson.control;

import entityForPerson.repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    public List getCity(@RequestParam String city) {
        return repository.getPersons(city);
    }
}
