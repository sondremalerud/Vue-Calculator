package no.ntnu.sondrmal.calculator.backend.repository;

import no.ntnu.sondrmal.calculator.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
