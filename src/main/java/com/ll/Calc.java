package com.ll;

public class Calc {
    public static int run(String expression) {
        String[] expressionBits = expression.split(" ");

        int num1 = Integer.parseInt(expressionBits[0]);
        int num2 = Integer.parseInt(expressionBits[2]);
        int num3 = Integer.parseInt(expressionBits[4]);

        String operationSymbol = expressionBits[1];

        int result = 0;
        switch (operationSymbol) {
            case "+":
                result = num1 + num2 + num3;
                break;
            case "-":
                result = num1 - num2;
        }
        return result;
    }

}
