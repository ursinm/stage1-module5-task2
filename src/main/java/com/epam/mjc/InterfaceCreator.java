package com.epam.mjc;

import java.util.List;
import java.util.stream.Collectors;

public class InterfaceCreator {

    // Реализация метода divideBy, который возвращает Operation, делящий элементы списка на divider
    public Operation<Integer> divideBy(Integer divider) {
        return list -> list.stream()
                           .map(element -> element / divider)  // Операция деления каждого элемента
                           .collect(Collectors.toList());     // Собираем результат в список
    }
}
