package com.verkeerslicht.datastructures;

import com.verkeerslicht.model.Auto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LinkedList<T> {

     private AutoNode head;
     private int size;

    public void addToFront(Auto auto){
         AutoNode node = new AutoNode(auto);
        node.setNext(head);
        head = node;
        size++;
    }


    public Auto removeFromFront(){
        if (isEmpty()){
            return null;
        }
        AutoNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode.getAuto();
    }

    public Auto peek(){
        return head.getAuto();
    }


    public boolean isEmpty(){
        return head == null;
    }


}
