package com.verkeerslicht.datastructures;


import com.verkeerslicht.model.Auto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LinkedList {

    private Node head;
    private Node tail;
    private int size;


    public void addToFront(Auto auto) {
        Node node = new Node(auto);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
        }
        head = node;
        size++;
    }

    public Auto removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        Node removedNode = head;
        head = head.getNext();
        size--;
        return removedNode.getAuto();
    }

    public Auto peek() {
        if (isEmpty()) {
            return null;
        }
        return head.getAuto();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addToBack(Auto auto) {
        Node newNode = new Node(auto);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
        }
        tail = newNode;
        size++;
    }
}
