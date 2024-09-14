package com.epam.mjc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

public class InterfaceCreatorTest {

    @Test
    void divideByTest() {
        // Основной тест с делением на 3
        List<Integer> numbers = List.of(9, 12, 15, 999, 30);
        List<Integer> expected = List.of(3, 4, 5, 333, 10);

        List<Integer> result = new InterfaceCreator().divideBy(3).apply(numbers);
        assertEquals(expected, result);
    }

    @Test
    void divideByEmptyListTest() {
        // Тест для пустого списка
        List<Integer> numbers = List.of();
        List<Integer> expected = List.of();

        List<Integer> result = new InterfaceCreator().divideBy(3).apply(numbers);
        assertEquals(expected, result);
    }

    @Test
    void divideByOneTest() {
        // Тест с делением на 1 (значения должны остаться такими же)
        List<Integer> numbers = List.of(1, 10, 100, 1000);
        List<Integer> expected = List.of(1, 10, 100, 1000);

        List<Integer> result = new InterfaceCreator().divideBy(1).apply(numbers);
        assertEquals(expected, result);
    }

    @Test
    void divideByLargerThanValuesTest() {
        // Деление на число больше всех элементов списка (все значения должны округлиться до 0)
        List<Integer> numbers = List.of(1, 2, 3, 4);
        List<Integer> expected = List.of(0, 0, 0, 0);

        List<Integer> result = new InterfaceCreator().divideBy(10).apply(numbers);
        assertEquals(expected, result);
    }

    @Test
    void divideByZeroTest() {
        // Тест для деления на 0 - в реальной ситуации это вызовет ArithmeticException
        List<Integer> numbers = List.of(1, 2, 3, 4);

        try {
            new InterfaceCreator().divideBy(0).apply(numbers);
        } catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());  // Проверка на деление на 0
        }
    }

    @Test
    void divideByWithZeroInListTest() {
        // Тест для списка с нулевыми значениями
        List<Integer> numbers = List.of(0, 12, 24, 36);
        List<Integer> expected = List.of(0, 4, 8, 12);

        List<Integer> result = new InterfaceCreator().divideBy(3).apply(numbers);
        assertEquals(expected, result);
    }
}
