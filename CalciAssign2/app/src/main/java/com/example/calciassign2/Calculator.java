package com.example.calciassign2;

public class Calculator {
    public String performOperation(Operation operation, int num1, int num2) {
        return operation.calculate(num1, num2);
    }
}
