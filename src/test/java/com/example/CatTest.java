package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class CatTest {

    @Test
    void getSoundReturnsMeow() {
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);

        Assertions.assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getFoodUsesPredatorEatMeat() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expected);

        Cat cat = new Cat(feline);
        List<String> actual = cat.getFood();

        Assertions.assertEquals(expected, actual);
        Mockito.verify(feline).eatMeat();
    }
}
