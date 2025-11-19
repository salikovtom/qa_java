package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FelineTest {

    @Test
    void eatMeatReturnsPredatorFood() throws Exception {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Assertions.assertEquals(expected, feline.eatMeat());
    }

    @Test
    void getFamilyReturnsCatsFamily() {
        Feline feline = new Feline();
        Assertions.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittensWithoutArgsReturnsOne() {
        Feline feline = new Feline();
        Assertions.assertEquals(1, feline.getKittens());
    }

    @Test
    void getKittensWithArgsReturnsPassedValue() {
        Feline feline = new Feline();
        Assertions.assertEquals(3, feline.getKittens(3));
    }
}