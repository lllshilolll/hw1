package org.example;

import java.util.function.Predicate;

/**
 * Сигнатуры методов в данном классе не менять
 */
public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Реализовать метод, который подсчитывает количество подходящих по условию узлов от 0 до N.
     * <br/>
     * Пример 1:
     * список 1, 2, 3, 4, 5
     * условие x < 4
     * ответ 3
     * <br/>
     * Пример 2:
     * список 1, 2, 3, 4, 5
     * условие x < 0
     * ответ 0
     *
     * @param list односвязный список
     * @param pred условие
     * @param <T>  - тип хранимых значений в списке
     * @return количество узлов от 0 до N, где N позиция на которой первый раз условие вернуло false
     */
    public <T> int partitionBy(Node<T> list, Predicate<T> pred) {
        if (list == null || pred == null) {
            throw new RuntimeException("Не переданы обязательные аргументы");
        }
        int count = 0;
        do {
            if (pred.test(list.getValue())) {
                count++;
            } else {
                return count;
            }
            list = list.getNext();
        }
        while (list != null);
        return count;
    }

    /**
     * <h1>Задание 2.</h1>
     * Реализовать метод поиска элемента на позиции N в переданном односвязном списке.
     *
     * @param list односвязный список
     * @param n    позиция искомого элемента
     * @param <T>
     * @return сам элемент
     */
    public <T> T findNthElement(Node<T> list, int n) {
        if(list == null){
            throw new RuntimeException("список должен содержать хотябы 1 элемент");
        }
        if (n >= list.size) {
            throw new RuntimeException("позиция искомого элемента больше размера: " + list.size);
        } else if (n < 0) {
            throw new RuntimeException("позиция искомого элемента должна быть больше 0");
        }
        for (int i = 0; i < n; i++) {
            list = list.getNext();
        }
        return list.getValue();
    }
}
