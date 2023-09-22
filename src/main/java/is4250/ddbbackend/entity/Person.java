package is4250.ddbbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED) // incase we need children entities
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String email;

    // we need to do some hashing shenanigans here
    @Column(nullable = false)
    private String password;

    // we can leave this empty, and it is automatically marked as @Column
    // with the default settings and configuration
    private String firstName;
    private String lastName;
    private Instant createdAt;

    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

//    private boolean enabled = true;


    // dont necessarily need this since we have getter&setters but neat to have
    public Person(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
