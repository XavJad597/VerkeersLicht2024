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
        if (head != null) {
            head.setPrev(null);
        } else {
            tail = null;
        }
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
    public void insertAfter(Node node, Auto auto) {
        Node newNode = new Node(auto);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    public void addBetween(Node previous, Node next, Auto auto) {
        // Create a new node
        Node newNode = new Node(auto);

        // Set the new node's next to the next node
        newNode.setNext(next);

        // Set the new node's previous to the previous node
        newNode.setPrev(previous);

        // Update the previous node's next to the new node
        if (previous != null) {
            previous.setNext(newNode);
        }

        // Update the next node's previous to the new node
        if (next != null) {
            next.setPrev(newNode);
        }

        // If the new node is inserted at the head
        if (previous == null) {
            head = newNode;
        }

        // If the new node is inserted at the tail
        if (next == null) {
            tail = newNode;
        }

        // Increment the size of the list
        size++;
    }
//    private Node head;
//    private int size;
//
//    public void addToFront(Auto auto) {
//        Node node = new Node(auto);
//        node.setNext(head);
//        head = node;
//        size++;
//    }
//
//    public Auto removeFromFront() {
//        if (isEmpty()) {
//            return null;
//        }
//        Node removedNode = head;
//        head = head.getNext();
//        size--;
//        return removedNode.getAuto();
//    }
//
//    public Auto peek() {
//        if (isEmpty()) {
//            return null;
//        }
//        return head.getAuto();
//    }
//
//    public boolean isEmpty() {
//        return head == null;
//    }
//
//    public void addToBack(Auto auto) {
//        Node newNode = new Node(auto);
//        if (isEmpty()) {
//            head = newNode;
//        } else {
//            Node current = head;
//            while (current.getNext() != null) {
//                current = current.getNext();
//            }
//            current.setNext(newNode);
//        }
//        size++;
//    }
//


}
