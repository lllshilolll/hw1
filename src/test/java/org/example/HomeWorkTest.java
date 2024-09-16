package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

public class HomeWorkTest {
    HomeWork homeWork = new HomeWork();

    @Test
    public void partitionByTest() {

        Node<Integer> node = new Node<>(1);
        node.add(2);
        node.add(3);
        node.add(4);
        node.add(5);
        node.add(6);

        Assertions.assertEquals(node.size, 6);
        Predicate<Integer> predicate1 = i -> i <= 6;
        Assertions.assertEquals(homeWork.partitionBy(node, predicate1), 6);
        Predicate<Integer> predicate2 = i -> i < 4;
        Assertions.assertEquals(homeWork.partitionBy(node, predicate2), 3);
        Predicate<Integer> predicate3 = i -> i < 0;
        Assertions.assertEquals(homeWork.partitionBy(node, predicate3), 0);

        Node<Integer> node2 = new Node<>(7);
        node2.add(3);
        node2.add(6);
        node2.add(0);
        node2.add(5);
        node2.add(9);
        node2.add(5);

        Assertions.assertEquals(node2.size, 7);
        Predicate<Integer> predicate21 = i -> i <= 6;
        Assertions.assertEquals(homeWork.partitionBy(node2, predicate21), 0);
        Predicate<Integer> predicate22 = i -> i > 0;
        Assertions.assertEquals(homeWork.partitionBy(node2, predicate22), 3);
        Predicate<Integer> predicate23 = i -> i == 7;
        Assertions.assertEquals(homeWork.partitionBy(node2, predicate23), 1);
    }

    @Test
    public void partitionByTestNullField() {
        Predicate<Integer> predicate1 = i -> i <= 6;
        Assertions.assertThrows(RuntimeException.class, () -> homeWork.partitionBy(null, predicate1));

        Node<Integer> node2 = new Node<>(7);
        node2.add(3);
        node2.add(6);
        node2.add(0);
        node2.add(5);
        node2.add(9);

        Assertions.assertThrows(RuntimeException.class, () -> homeWork.partitionBy(node2, null));
    }

    @Test
    public void findNthElementTest() {

        Node<Integer> node = new Node<>(1);
        node.add(2);
        node.add(3);
        node.add(4);
        node.add(5);
        node.add(6);
        Assertions.assertEquals(homeWork.findNthElement(node, 4), 5);

        Node<Integer> node2 = new Node<>(7);
        node2.add(3);
        node2.add(6);
        node2.add(0);
        node2.add(5);
        node2.add(9);
        Assertions.assertEquals(homeWork.findNthElement(node2, 3), 0);
    }

    @Test
    public void findNthElementTestException() {
        Node<Integer> node = new Node<>(1);
        node.add(2);
        node.add(3);
        node.add(4);
        node.add(5);
        node.add(6);

        Assertions.assertThrows(RuntimeException.class, () ->  homeWork.findNthElement(null, 3));
        Assertions.assertThrows(RuntimeException.class, () -> homeWork.findNthElement(node, 6));
        Assertions.assertThrows(RuntimeException.class, () -> homeWork.findNthElement(node, -5));

    }
}
