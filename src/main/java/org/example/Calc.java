package org.example;

public class Calc {
    public static int run(String exp) {
        boolean needToMulti = exp.contains("*");
        boolean needToSum = !exp.contains("*");
        exp = exp.replaceAll("\\- ", "\\+ \\-");
        int answer = 0;
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
