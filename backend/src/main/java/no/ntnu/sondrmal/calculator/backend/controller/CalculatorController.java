package no.ntnu.sondrmal.calculator.backend.controller;

import no.ntnu.sondrmal.calculator.backend.model.Equation;
import no.ntnu.sondrmal.calculator.backend.model.User;
import no.ntnu.sondrmal.calculator.backend.repository.UserRepository;
import no.ntnu.sondrmal.calculator.backend.repository.EquationRepository;
import no.ntnu.sondrmal.calculator.backend.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins={"*"})
public class CalculatorController {

    @Autowired
    private CalculatorService service;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EquationRepository equationRepository;


    Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @PostMapping("/calculations")
    public ResponseEntity calculateExpresssion(@RequestParam("expression") String expression, @RequestParam("username") String username) {
        logger.info("Equation received: " + expression);
        String answer = this.service.evaluate(expression);
        logger.info("Answer: " + answer);

        if (userRepository.findByUsername(username) == null) return new ResponseEntity(HttpStatus.BAD_REQUEST);

        logger.info("Saving equation to database for user " + username);
        equationRepository.save(new Equation(username, expression, answer));

        return new ResponseEntity(answer, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity checkUsername(@RequestParam("username") String username) {
        logger.info("Checking username: " + username);
        User user = userRepository.findByUsername(username);
        if (user == null) {
            logger.error("Username does not exist");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        logger.info("Username exists");
        return new ResponseEntity(user.getUsername(), HttpStatus.OK);
    }

    @GetMapping("/equations")
    public ResponseEntity getEquationsByUsername(@RequestParam("username") String username) {
        List<Equation> equations = equationRepository.findByUsername(username);
        return new ResponseEntity(equations, HttpStatus.OK);
    }


}
