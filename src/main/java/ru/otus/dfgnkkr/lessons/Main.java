package ru.otus.dfgnkkr.lessons;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public Integer[] cropArray(Integer[] in) {
        if (Arrays.asList(in).contains(1)) {
            int startPos = Arrays.asList(in).lastIndexOf(1) + 1; // интересуют элементы после последней 1
            return Arrays.copyOfRange(in, startPos, in.length);
        } else {
            throw new RuntimeException();
        }
    }

    public boolean checkArray(Integer[] in) {
        return Arrays.stream(in).noneMatch(e -> e > 2 || e == 0)
                && Arrays.stream(in).anyMatch(e -> e == 2)
                && Arrays.stream(in).anyMatch(e -> e == 1);
    }
}