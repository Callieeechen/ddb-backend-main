package is4250.ddbbackend.service;

import is4250.ddbbackend.entity.Person;
import is4250.ddbbackend.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    // note that this addGeneralUser can add Admins, Students, etc.
    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public Person getPersonById(Long id) {
        return personRepository.getReferenceById(id);
    }

    public Person getPersonByEmail(String email) {
        return personRepository.getPersonByEmail(email);
    }
}
