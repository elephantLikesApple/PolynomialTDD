package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Calc {
    public static int run(String exp) {
        if(!exp.contains((" "))) return Integer.parseInt(exp);

        exp = exp.replaceAll("\\- ", "\\+ \\-");
        boolean needToMulti = exp.contains("*");
        boolean needToSum = exp.contains("+");
        boolean needToCompound = needToMulti && needToSum;

        int answer = 0;
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
}
