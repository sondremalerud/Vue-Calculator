package no.ntnu.sondrmal.calculator.backend.controller;

import no.ntnu.sondrmal.calculator.backend.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins={"*"})
public class CalculatorController {

    @Autowired
    private CalculatorService service;
    Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @PostMapping("/calculations")
    public ResponseEntity calculateExpresssion(@RequestParam("expression") String expression) {
        logger.info("Expression received: " + expression);
        String answer = this.service.evaluate(expression);
        logger.info("Answer: " + answer);
        return new ResponseEntity(answer, HttpStatus.OK);
    }
}
