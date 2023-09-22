package is4250.ddbbackend.controller;

import is4250.ddbbackend.entity.Person;
import is4250.ddbbackend.service.PersonService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    // injects service
    @Autowired
    PersonService personService;
    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{email}")
    public Person getPersonByEmail(@PathVariable String email) {
        return personService.getPersonByEmail(email);
    }
    @PostMapping
    public ResponseEntity<?> addPerson(@RequestBody Person p) {
        try {
            personService.addPerson(p);
            return ResponseEntity.ok("Person with email " + p.getEmail() + " created");
        } catch (Exception e) {
//             sth went wrong
            return ResponseEntity.internalServerError().body(e);
        }
    }

}
