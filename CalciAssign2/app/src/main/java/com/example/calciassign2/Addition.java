package com.example.calciassign2;

public class Addition implements Operation {
    @Override
    public String calculate(int num1, int num2) {
        return "Answer = " + (num1 + num2);
    }
}
