package com.example.calciassign2;

public class Division implements Operation {
    @Override
    public String calculate(int num1, int num2) {
        if (num2 == 0) {
            return "Cannot divide by zero";
        }
        return "Answer = " + ((float) num1 / num2);
    }
}
