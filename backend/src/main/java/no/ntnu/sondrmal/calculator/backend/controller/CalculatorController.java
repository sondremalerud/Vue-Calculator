package no.ntnu.sondrmal.calculator.backend.controller;

import no.ntnu.sondrmal.calculator.backend.service.CalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins={"*"})
public class CalculatorController {


    @PostMapping("/calculations")
    public ResponseEntity calculateExpresssion(@RequestParam("expression") String expression) {

        String answer = CalculatorService.evaluate(expression);
        System.out.println(expression);
        System.out.println(CalculatorService.evaluate(expression));
        return new ResponseEntity(answer, HttpStatus.OK);
    }

    @GetMapping("/kebab")
    public void kebab() {


        System.out.println("kebab");

    }


}
