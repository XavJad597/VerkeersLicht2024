package com.verkeerslicht.datastructures;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LinkedList<T> {

        private Node<T> head;
        public LinkedList() {
            head = null;
        }

        public void add(T auto) {
            Node<T> node = new Node<>(auto);
            if (head == null) {
                head = node;
            } else {
                Node<T> current = head;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(node);
            }
        }

        public boolean isEmpty() {
            return head == null;
        }

    public T removeFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
       T auto =  head.getVehicle();
        head = head.getNext();
        return auto;
    }


    public T removeLast() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }

        if (head.getNext() == null) {
            T last = head.getVehicle();
            head = null;
            return last;
        }

        Node<T> current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }

        T last = current.getNext().getVehicle();
        current.setNext(null);
        return last;
    }

    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
}
