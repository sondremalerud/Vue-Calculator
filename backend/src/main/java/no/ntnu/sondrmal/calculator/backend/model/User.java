package no.ntnu.sondrmal.calculator.backend.model;

import jakarta.persistence.*;

//import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class User {

    @Column(name = "username")
    private String username;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }


}
