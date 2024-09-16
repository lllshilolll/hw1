package org.example;

import lombok.Getter;
import lombok.Setter;


/**
 * Реализация базовой структуры односвязного списка
 * При необходимости, можно доработать реализацию
 *
 * @param <T>
 */
@Getter
@Setter
public class Node<T> {

    private T value;

    private Node<T> next;

    int size = 0;

    public Node(T value) {
        this.value = value;
        size++;
    }

    public Node<T> add(T value) {
        Node<T> emptyNode = this;
        while (emptyNode.getNext() != null) {
            emptyNode = emptyNode.getNext();
        }

        Node<T> newNode = new Node<>(value);
        emptyNode.setNext(newNode);
        size++;
        return newNode;
    }
}
