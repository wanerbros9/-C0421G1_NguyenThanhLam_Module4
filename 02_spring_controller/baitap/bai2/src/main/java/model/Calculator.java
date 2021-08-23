package model;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    public double calculate(double leftOperand, String operator, double rightOperand) {
        double result;
        switch (operator) {
            case "addition":
                result = leftOperand + rightOperand;
                break;
            case "subtraction":
                result = leftOperand - rightOperand;
                break;
            case "multiple":
                result = leftOperand * rightOperand;
                break;
            case "division":
                if (rightOperand != 0) {
                    result = leftOperand / rightOperand;
                }else {
                    throw new RuntimeException("Can't div by zero");
                }
                break;
            default:
                throw new RuntimeException("Invalid operation");
        }
        return result;
    }
}
