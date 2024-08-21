package com.verkeerslicht.datastructures;

import com.verkeerslicht.model.Auto;


public class AutoStack {
    private final LinkedList stack;


    public AutoStack() {
        stack = new LinkedList();

    }

    public void push(Auto auto) {
        stack.addToFront(auto);
    }

    public Auto pop() {
        return stack.removeFromFront();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public Auto peek(){
        return stack.peek();
    }

    public int getSize(){
        return stack.getSize();
    }


    public void printStack(){

        while (!isEmpty()){
            System.out.println(stack.removeFromFront());
        }

    }

}
