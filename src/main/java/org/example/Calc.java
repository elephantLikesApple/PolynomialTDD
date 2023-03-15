package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Calc {
    public static int run(String exp) {
        if(!exp.contains(" ")) return Integer.parseInt(exp);

        exp = stripBracket(exp); // 불필요한 괄호 제거

        exp = exp.replaceAll("\\- ", "\\+ \\-");
        boolean needToMulti = exp.contains("*");
        boolean needToSum = exp.contains("+");
        boolean needTobracket = exp.contains("(") || exp.contains(")");
        boolean needToCompound = needToMulti && needToSum;
        int answer = 0;

        if(needTobracket) {
            int splitPointIndex = findSplitPointIndex(exp);

            String firstExp = exp.substring(0, splitPointIndex-1);
            String secondExp = exp.substring(splitPointIndex + 2);
            char operation = exp.charAt(splitPointIndex);

            exp = Calc.run(firstExp) + " " + operation + " " + Calc.run(secondExp);
            return Calc.run(exp);
        }
        else if(needToCompound) {
            String[] bits = exp.trim().split(" \\+ ");

            String newExp = Arrays.stream(bits)
                    .mapToInt(Calc::run)
                    .mapToObj( e -> e+"")
                    .collect(Collectors.joining(" + "));

            return run(newExp);
        }
        else if(needToSum) {
            String[] bits = exp.trim().split(" \\+ ");
            for (int i = 0; i < bits.length; i++) {
                answer += Integer.parseInt(bits[i]);
            }
        }
        else if(needToMulti) {
            answer = 1;
            String[] bits = exp.trim().split(" \\* ");
            for(int i = 0; i < bits.length; i++){
                answer *= Integer.parseInt(bits[i]);
            }
        }
        return answer;
    }

    private static int findSplitPointIndexBy(String exp, char findChar) {
        int bracketsCount = 0;

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if ( c == '(' ) {
                bracketsCount++;
            }
            else if ( c == ')' ) {
                bracketsCount--;
            }
            else if ( c == findChar ) {
                if ( bracketsCount == 0 ) return i;
            }
        }

        return -1;
    }

    private static int findSplitPointIndex(String exp) {
        int index = findSplitPointIndexBy(exp, '+');

        if ( index >= 0 ) return index;

        return findSplitPointIndexBy(exp, '*');
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
