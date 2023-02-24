package no.ntnu.sondrmal.calculator.backend.service;

import net.objecthunter.exp4j.ExpressionBuilder;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    
    public String evaluate(String expression) {
        ExpressionBuilder eb = new ExpressionBuilder(expression);
        return ""+eb.build().evaluate();
    }
}
