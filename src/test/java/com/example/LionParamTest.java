package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

class LionParamTest {

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void lionManeDependsOnSex(String sex, boolean expectedHasMane) throws Exception {
        Feline feline = Mockito.mock(Feline.class);

        Lion lion = new Lion(sex, feline);

        Assertions.assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
