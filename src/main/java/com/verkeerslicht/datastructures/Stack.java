package com.verkeerslicht.datastructures;

import com.verkeerslicht.model.Auto;
import org.w3c.dom.Node;


public class Stack {
    private final LinkedList<Auto> stack;


    public Stack() {
        stack = new LinkedList<>();
    }

    public void push(Auto auto) {
        stack.add(auto);
    }

    public Auto pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.removeLast();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}
