package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class LionTest {

    @Test
    void maleLionHasMane() throws Exception {
        Feline feline = Mockito.mock(Feline.class);

        Lion lion = new Lion("Самец", feline);

        Assertions.assertTrue(lion.doesHaveMane());
    }

    @Test
    void femaleLionHasNoMane() throws Exception {
        Feline feline = Mockito.mock(Feline.class);

        Lion lion = new Lion("Самка", feline);

        Assertions.assertFalse(lion.doesHaveMane());
    }

    @Test
    void invalidSexThrowsException() {
        Feline feline = Mockito.mock(Feline.class);

        Exception exception = Assertions.assertThrows(
                Exception.class,
                () -> new Lion("Неопознанный", feline)
        );
    }

    @Test
    void getKittensDelegatesToFeline() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", feline);
        int actual = lion.getKittens();

        Assertions.assertEquals(3, actual);
        Mockito.verify(feline).getKittens();
    }

    @Test
    void getFoodDelegatesToFelinePredatorFood() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        // если в Lion.getFood() используешь feline.eatMeat(),
        // вместо строки выше:
        // Mockito.when(feline.eatMeat()).thenReturn(expected);

        Lion lion = new Lion("Самец", feline);
        List<String> actual = lion.getFood();

        Assertions.assertEquals(expected, actual);
        Mockito.verify(feline).getFood("Хищник");
        // или verify(feline).eatMeat(); — под фактическую реализацию
    }
}
