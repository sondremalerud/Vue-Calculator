package no.ntnu.sondrmal.calculator.backend.repository;

import no.ntnu.sondrmal.calculator.backend.model.Equation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquationRepository extends JpaRepository<Equation, Long> {
    List<Equation> findByUsername(String username);

}
