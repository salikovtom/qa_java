package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FelineParamTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 10})
    void getKittensWithArgsReturnsSameValue(int kittensCount) {
        Feline feline = new Feline();

        int actual = feline.getKittens(kittensCount);

        Assertions.assertEquals(kittensCount, actual);
    }
}
