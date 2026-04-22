package com.ll;

public class Calc {
    public static int run(String expression) {
        int result = 0;
        result = devide(expression);

        return result;
    }
    public static int devide(String expression) {
        expression = expression.trim();

        //전체 괄호 제거용
        if (expression.startsWith("(") && expression.endsWith(")")) {
            if (isWrapped(expression)) {
                return devide(expression.substring(1, expression.length() - 1));
            }
        }

        int level = 0;


        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (c == ')') level++;
            else if (c == '(') level--;

            if (level == 0) {
                // " - " 또는 " + " 처럼 앞뒤 문맥을 확인하여 연산자인지 판별
                if ((c == '+' || c == '-') && i > 0 && expression.charAt(i - 1) == ' ') {
                    String left = expression.substring(0, i).trim();
                    String right = expression.substring(i + 1).trim();
                    return c == '+' ? devide(left) + devide(right) : devide(left) - devide(right);
                }
            }
        }
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (c == ')') level++;
            else if (c == '(') level--;

            if (level == 0) {
                // " - " 또는 " + " 처럼 앞뒤 문맥을 확인하여 연산자인지 판별
                if ((c == '*' || c == '/') && i > 0 && expression.charAt(i - 1) == ' ') {
                    String left = expression.substring(0, i).trim();
                    String right = expression.substring(i + 1).trim();
                    return c == '*' ? devide(left) * devide(right) : devide(left) / devide(right);
                }
            }
        }



        return Integer.parseInt(expression);
    }

    private static boolean isWrapped(String expression) {
       // 괄호가 짝이 맞는지 확인하는 방법: '('의 개수와 ')'의 개수가 같아야 함
        return expression.chars()
                .filter(ch -> ch == '(')
                .count()
                ==
                expression.chars()
                .filter(ch -> ch == ')')
                .count();
    }


}
