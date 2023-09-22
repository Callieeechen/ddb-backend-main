package is4250.ddbbackend.repository;

import is4250.ddbbackend.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // maybe we want to use CrudRepository, do more research later

    Person getPersonByEmail(String email);
    // this is the magical part, just define the method; as long as the method name matches a certain pattern it will
    // automatically be created accordingly

}
