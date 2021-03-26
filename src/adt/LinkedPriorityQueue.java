/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import java.io.Serializable;

/**
 *
 * @author YJ
 * @param <T>
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class LinkedPriorityQueue<T extends Comparable<T>> implements PriorityQueueInterface<T>, Serializable {

    private Node firstNode; // reference to first node
    private int length;  // number of elements in queue

    public LinkedPriorityQueue() {
        firstNode = null; // first node data initialized to null
        length = 0; // // length of queue initialized to 0
    }

    @Override
    public boolean enqueue(T newElement) {
        boolean successful = true;

        if (!contains(newElement)) {  // to avoid duplication of record
            Node newNode = new Node(newElement, null);

            Node currentNode = firstNode;
            Node previousNode = null;

            while (currentNode != null && newElement.compareTo(currentNode.data) > 0) { // compare each element in queue to check if given element has higher priority
                previousNode = currentNode;
                currentNode = currentNode.next;
            }

            if (isEmpty() || (previousNode == null)) { // if queue is initially empty or element has the highest priority
                newNode.next = firstNode;
                firstNode = newNode;
            } else { // insert at position found or at the end of queue
                newNode.next = currentNode;
                previousNode.next = newNode;
            }
            length++; // increase length of queue

        } else { // return false if unsuccessful
            successful = false;
        }
        return successful;
    }

    @Override
    public T dequeue() {
        T front = null;
        if (!isEmpty()) { // if queue is not empty
            front = firstNode.data;
            firstNode = firstNode.next; // point to the node after first node (remove first node)
            length--;
        }
        return front;
    }

    @Override
    public boolean remove(T anElement) {
        if (!isEmpty()) {
            Node previousNode = null;
            Node currentNode = firstNode;
            while (currentNode != null && currentNode.data.compareTo(anElement) < 0) {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            if (currentNode != null && currentNode.data.equals(anElement)) {
                if (currentNode == firstNode) {
                    firstNode = firstNode.next;
                } else {
                    previousNode.next = currentNode.next;
                }
                length--;
                return true;
            }
        }
        return false;
    }

    @Override
    public T getFront() {
        T front = null;

        if (!isEmpty()) { // if queue is not empty
            front = firstNode.data; // get data of first node
        }
        return front;
    }

    @Override
    public int getTotalEntry() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public T getElement(int position) {
        T result = null;

        if ((position >= 1) && (position <= length)) {
            Node currentNode = firstNode;
            for (int i = 0; i < position - 1; ++i) {
                currentNode = currentNode.next;		// advance currentNode to next node
            }
            result = currentNode.data;	// currentNode is pointing to the node at givenPosition
        }
        return result;
    }

    @Override
    public final void clear() {
        firstNode = null; // remove the reference to the first node
        length = 0; // clear the number of elements
    }

    @Override
    public String toString() {
        String str = "";
        Node currentNode = firstNode;
        int i = 0;
        while (currentNode != null) {
            str += (i + 1) + ". " + currentNode.data + "\n";
            i++;
            currentNode = currentNode.next;
        }
        return str;
    }

    @Override
    public boolean contains(T newElement) {
        boolean exist = false;
        Node currentNode = firstNode;
        while (currentNode != null && !exist) { // loop through the queue
            if (currentNode.data.equals(newElement)) { // check if element already existed
                exist = true;
            } else {
                currentNode = currentNode.next; // move to the next node
            }
        }
        return exist;
    }

    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}