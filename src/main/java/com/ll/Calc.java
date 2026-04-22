package com.ll;

import java.util.Arrays;

public class Calc {
    public static int run(String expression) {
        int result = 0;
        String[] expressionArr = expression.split(" ");
        int[] numbers =  Arrays.stream(expressionArr)
                .filter(s -> s.matches("-?\\d+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[] operationSymbols = Arrays.stream(expressionArr)
                .filter(s -> s.matches("[+-/*]"))
                .toArray(String[]::new);
        result = numbers[0];
        int count = 1;
        for(String op : operationSymbols){
            switch (op){
                case "+" -> result += numbers[count];
                case "-" -> result -= numbers[count];
                case "*" -> result *= numbers[count];
                case "/" -> result /= numbers[count];
            }
            count ++;
        }

       return result;
    }

}
