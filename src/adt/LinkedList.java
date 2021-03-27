/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author winnieyap
 * @param <T>
 */
public class LinkedList<T extends Comparable<T>> implements ListInterface<T>,Serializable {

    private Node head;
    private int length;	// number of entries in list/size

    public LinkedList() {
        head = null;
        length = 0;
    }

    @Override
    public boolean addFirst(T newEntry) {
        boolean status = false;
        Node node = new Node(newEntry);
        if (isEmpty()) {
            head = node;
            status = true;
        } else {
            node.next = head;
            head = node;
            status =true;
        }
        length++;
        return status;
    }

    @Override
    public boolean addLast(T newEntry) {
        Node node = new Node(newEntry);
        if (isEmpty()) {
            head = node;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = node;
        }
        length++;
        return true;
    }

    @Override
    public boolean addAt(int newPosition, T newEntry) {
        //node object that stored value to be enter into list
        Node node = new Node(newEntry);
        boolean isSuccessful = true;

        //validation of newPosition
        if (validatePosition(newPosition)) {
            //add element at front if the list is empty
            if (isEmpty() || newPosition == 1) {
                node.next = head;
                head = node;
            } else {
                //finding the node before
                Node nodeBefore = head;
                for (int i = 1; i < newPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;
                }
                node.next = nodeBefore.next;	// make new node point to current node at newPosition
                nodeBefore.next = node;
            }
            length++;
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    @Override
    public T removeAt(int givenPosition) {
        T removedEntry = null;
        Node removedNode = null;

        //check for given Position is available or not
        //loop to get the element at given position
        //remove and re-assign the node
        if (validatePosition(givenPosition)) {
            if (givenPosition == 1) {  //remove first element 
                removedNode = head;
                head = head.next;
            } else {  //remove others position element 

                //finding the node before to be removed
                Node nodeBefore = head;
                for (int i = 1; i < givenPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;
                }
                removedNode = nodeBefore.next;	// node to be removed
                nodeBefore.next = removedNode.next; //pointing node before remove to the node that being remove ltr
            }
            removedEntry = (T) removedNode.data;
            length--;
        }

        return removedEntry;
    }

    //can add a function called remove last which remove the last record in the list
    @Override
    public void clear() {
        length = 0;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isReplaced = true;

        //check for given Position is available or not
        //loop till the element at given position
        //replace the original element with newEntry
        if (validatePosition(givenPosition)) {

            //finding the node before to be removed
            Node nodeReplace = head;
            for (int i = 1; i <= givenPosition - 1; i++) {
                nodeReplace = nodeReplace.next;
            }
            nodeReplace.data = newEntry;	//update the latest newEntry   

        } else {
            isReplaced = false;
        }
        return isReplaced;
    }

    @Override
    public T getEntry(int givenPosition) {
        T entry = null;
        Node entryNode = null;

        //check for given Position is available or not
        //loop to get the element at given position
        //return the element
        if (validatePosition(givenPosition)) {
//            if (givenPosition == 1) {
//                entryNode = head;
//                head = head.next;
//            } else {
            Node nodeBefore = head;
            for (int i = 1; i <= givenPosition - 1; ++i) {
                nodeBefore = nodeBefore.next;
            }
            entryNode = nodeBefore;	// return the node

            //}
            entry = (T) entryNode.data;
        }
        return entry;
    }

    @Override
    public boolean contains(T anEntry) {
//        boolean isContain = false;
//
//        Node node = new Node(anEntry);
//
//        //check for given Entry is null or not
//        //loop till find similar element in the list
//        //return true or false
//        if (anEntry != null) {
//            Node nodeBefore = head;
//            for (int i = 1; i <= length; ++i) {
//                //check each element wether is similar item
//                if (nodeBefore == anEntry) {
//                    isContain = true;
//                    break;
//                } else {
//                    nodeBefore = nodeBefore.next;
//                }
//            }
//        }
//        return isContain;

        boolean found = false;
        Node currentNode = head;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }
        return found;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean isFull() {
        return false; //it will never full 
    }

    //self introduced method 
    private boolean validatePosition(int newPosition) {
        return newPosition >= 1 && newPosition <= length + 1;
    }

    @Override
    public String toString() {
        int items = 1;
        String outputStr = "";
        Node currentNode = head;
        while (currentNode != null) {
            outputStr += items + "." + currentNode.data + "\n";
            currentNode = currentNode.next;
            items++;
        }
        return outputStr;
    }

    @Override
    public void swap(int frontPosition, int backPosition) {
        T frontEntry = null;
        T backEntry = null;
        //implement of swap
        frontEntry = getEntry(frontPosition);
        backEntry = getEntry(backPosition);
        replace(frontPosition,backEntry);
        replace(backPosition,frontEntry);
    }

    @Override
    public T remove(T newEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPosition(T anEntry) {
        if (contains(anEntry) != true){
            return -1;
        }
        boolean found = false;
        Node currentNode = head;
        int count =1;
        while (!found && currentNode != null) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
                count++;
            }
        }
        return count;
    }

    private class Node<T> implements Serializable{

        T data; // entry in list
        Node next; // link to next node

        //empty constructor
        public Node() {

        }

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    public Iterator<T> getIterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node<T> trav = head;

        @Override
        public boolean hasNext() {
            return trav != null;
        }

        @Override
        public T next() {
            T data = trav.data;
            trav = trav.next;
            return data;
        }

    }

}
