package org.example;

public class Calc {
    public static int run(String exp) {
        exp = exp.replaceAll("\\- ", "\\+ \\-");
        boolean needToMulti = exp.contains("*");
        boolean needToSum = exp.contains("+");
        boolean needToCompound = needToMulti && needToSum;

        int answer = 0;
        if(needToCompound) {
            String[] bits = exp.trim().split(" \\+ ");
            return Integer.parseInt(bits[0]) + run(bits[1]);
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
