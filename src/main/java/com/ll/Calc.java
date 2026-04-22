package com.ll;

public class Calc {
    public static int run(String expression) {
        int result = 0;
        result = devide(expression);

        return result;
    }
    public static int devide(String expression) {

        // 1. 가장 뒤에 있는 + 또는 -를 찾는다 (lastIndexOf)
        if(expression.lastIndexOf(" + ") != -1) {
            int index = expression.lastIndexOf("+");
            String left = expression.substring(0, index);
            String right = expression.substring(index + 1);

            return devide(left) + devide(right);
        }

        if(expression.lastIndexOf(" - ") != -1) {
            int index = expression.lastIndexOf("-");
            String left = expression.substring(0, index);
            String right = expression.substring(index + 1);

            return devide(left) - devide(right);
        }

        // 3. 1번이 없다면, 가장 뒤에 있는 * 또는 /를 찾는다.
        if(expression.lastIndexOf(" * ") != -1) {
            int index = expression.lastIndexOf("*");
            String left = expression.substring(0, index);
            String right = expression.substring(index + 1);

            return devide(left) * devide(right);
        }
        if(expression.lastIndexOf(" / ") != -1) {
            int index = expression.lastIndexOf("/");
            String left = expression.substring(0, index);
            String right = expression.substring(index + 1);

            return devide(left) / devide(right);
        }
        return Integer.parseInt(expression.trim());
    }



}
