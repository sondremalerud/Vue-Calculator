package no.ntnu.sondrmal.calculator.backend.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import no.ntnu.sondrmal.calculator.backend.model.Equation;
import no.ntnu.sondrmal.calculator.backend.model.User;
import no.ntnu.sondrmal.calculator.backend.repository.UserRepository;
import no.ntnu.sondrmal.calculator.backend.repository.EquationRepository;
import no.ntnu.sondrmal.calculator.backend.security.JWTAuthorizationFilter;
import no.ntnu.sondrmal.calculator.backend.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.time.Instant;

@RestController
@EnableAutoConfiguration
@CrossOrigin(origins={"*"})
public class CalculatorController {

    // keyStr is hardcoded here for testing purpose
    // in a real scenario, it should either be stored in a database or injected from the environment
    public static final String keyStr = "testsecrettestsecrettestsecrettestsecrettestsecret";
    private static final Duration JWT_TOKEN_VALIDITY = Duration.ofMinutes(5);

    @Autowired
    private CalculatorService service;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EquationRepository equationRepository;



    private JWTAuthorizationFilter authorizationFilter = new JWTAuthorizationFilter();


    Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @PostMapping("/calculations")
    public ResponseEntity calculateExpresssion(@RequestParam("expression") String expression, @RequestParam("username") String username) {
        logger.info("Equation received: " + expression);
        String answer = this.service.evaluate(expression);
        logger.info("Answer: " + answer);
        logger.info("Token: " + username);

        String usrname = authorizationFilter.validateTokenAndGetUserId(username);

        logger.info("Saving equation to database for user " + usrname);
        equationRepository.save(new Equation(usrname, expression, answer));

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
        return new ResponseEntity(generateToken(username), HttpStatus.OK);

        //return new ResponseEntity(user.getUsername(), HttpStatus.OK);
    }

    @GetMapping("/equations")
    public ResponseEntity getEquationsByUsername(@RequestParam("username") String username) {
        String usrname = authorizationFilter.validateTokenAndGetUserId(username);



        List<Equation> equations = equationRepository.findByUsername(usrname);
        return new ResponseEntity(equations, HttpStatus.OK);
    }


    public String generateToken(final String userId) {
        final Instant now = Instant.now();
        final Algorithm hmac512 = Algorithm.HMAC512(keyStr);;
        final JWTVerifier verifier = JWT.require(hmac512).build();
        return JWT.create()
                .withSubject(userId)
                .withIssuer("idatt2105_token_issuer_app")
                .withIssuedAt(now)
                .withExpiresAt(now.plusMillis(JWT_TOKEN_VALIDITY.toMillis()))
                .sign(hmac512);
    }


}
