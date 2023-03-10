package org.example;

public class Calc {
    public static int run(String exp) {
        String[] bits = exp.trim().split(" ");
        int a = Integer.parseInt(bits[0]);
        String op = bits[1];
        int b = Integer.parseInt(bits[2]);
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            default -> a;
        };
    }
}
