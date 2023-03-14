package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Calc {
    public static int run(String exp) {
        if(!exp.contains((" "))) return Integer.parseInt(exp);

        exp = stripBracket(exp); // 불필요한 괄호 제거

        exp = exp.replaceAll("\\- ", "\\+ \\-");
        boolean needToMulti = exp.contains("*");
        boolean needToSum = exp.contains("+");
        boolean needTobracket = exp.contains("(") || exp.contains(")");
        boolean needToCompound = needToMulti && needToSum;


        int answer = 0;

        if(needTobracket) {
            int braketsCount = 0;
            int splitPoint = -1;
            for(int i = 0; i < exp.length(); i++) {
                if(exp.charAt(i) == '(') {
                    braketsCount++;
                }
                else if( exp.charAt(i) == ')') {
                    splitPoint = i;
                    braketsCount--;
                }
                if(braketsCount == 0) break;
            }

            String first = exp.substring(0, splitPoint+1);
            String second = exp.substring(splitPoint+4);

            return Calc.run(first) + Calc.run(second);
        }
        if(needToCompound) {
            String[] bits = exp.trim().split(" \\+ ");

            String newExp = Arrays.stream(bits)
                    .mapToInt(Calc::run)
                    .mapToObj( e -> e+"")
                    .collect(Collectors.joining(" + "));

            return run(newExp);
        }
        if(needToSum) {
            String[] bits = exp.trim().split(" \\+ ");
            for (int i = 0; i < bits.length; i++) {
                answer += Integer.parseInt(bits[i]);
            }
        }
        if(needToMulti) {
            answer = 1;
            String[] bits = exp.trim().split(" \\* ");
            for(int i = 0; i < bits.length; i++){
                answer *= Integer.parseInt(bits[i]);
            }
        }
        return answer;
    }

    public static String stripBracket(String exp){
        int outerBracketsCount = 0;
        while (exp.charAt(outerBracketsCount) == '(' && exp.charAt(exp.length() - 1 - outerBracketsCount) == ')') {
            outerBracketsCount++;
        }
        if(outerBracketsCount == 0) return exp;
        return exp.substring(outerBracketsCount, exp.length() - outerBracketsCount);
    }
}
