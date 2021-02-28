/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author winnieyap
 */
public class Node<T> {

    T data; // entry in list
    Node next; // link to next node
    
    //empty constructor
    public Node(){
        
    }

    public Node(T data) {
        this.data = data;
        next = null;
    }

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

}
