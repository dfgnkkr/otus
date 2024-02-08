package ru.otus.dfgnkkr.lessons;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MainTests {
    Main main;

    @BeforeEach
    public void init() {
        main = new Main();
    }

    @Test
    public void testSuccessfulCrop() {
        Integer[] in = {1, 2, 3, 41, 2, 1, 0, 0};
        Integer[] out = {0, 0};
        Assertions.assertArrayEquals(out, main.cropArray(in));
    }

    @Test
    public void testSuccessfulCrop1() { // да, нейминг не на высоте
        Assertions.assertAll(
                () -> {
                    Integer[] in = {1};
                    Integer[] out = {};
                    Assertions.assertArrayEquals(out, main.cropArray(in));
                },
                () -> {
                    Integer[] in = {1, 0};
                    Integer[] out = {0};
                    Assertions.assertArrayEquals(out, main.cropArray(in));
                },
                () -> {
                    Integer[] in = {0, 1};
                    Integer[] out = {};
                    Assertions.assertArrayEquals(out, main.cropArray(in));
                }
        );
    }

    @Test
    public void testFailedCrop() {
        Integer[] array = {2, 3};
        Assertions.assertThrows(RuntimeException.class, () -> main.cropArray(array));
    }

    @CsvSource({
            "6,2,3",
            "4,2,0"
    })
    @ParameterizedTest
    public void parameterizedTestFailedCrop(int a, int b, int c) {
        Integer[] array = {a, b, c};
        Assertions.assertThrows(RuntimeException.class, () -> main.cropArray(array));
    }

    @Test
    public void testTrueResultCheck() {
        Integer[] array = {1, 2, 1, 2};
        Assertions.assertTrue(main.checkArray(array));
    }

    @Test
    public void testFalseResultCheck() {
        Assertions.assertAll(
                () -> {
                    Integer[] array = {1, 2, 0, 1, 2};
                    Assertions.assertFalse(main.checkArray(array));
                },
                () -> {
                    Integer[] array = {2, 2};
                    Assertions.assertFalse(main.checkArray(array));
                },
                () -> {
                    Integer[] array = {1, 1};
                    Assertions.assertFalse(main.checkArray(array));
                },
                () -> {
                    Integer[] array = {1, 2, 3, 1, 2};
                    Assertions.assertFalse(main.checkArray(array));
                }
        );
    }


}
