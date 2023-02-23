package no.ntnu.sondrmal.calculator.backend.service;

import net.objecthunter.exp4j.ExpressionBuilder;

public class CalculatorService {
    
    public static String evaluate(String expression) {
        ExpressionBuilder eb = new ExpressionBuilder(expression);
        return ""+eb.build().evaluate();
    }
}
