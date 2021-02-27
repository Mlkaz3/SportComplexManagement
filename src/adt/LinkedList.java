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
public class LinkedList<T> implements ListInterf<T> {

    private Node head;
    private int length;	// number of entries in list/size

    @Override
    public boolean addFront(T newEntry) {
        Node node = new Node(newEntry);

        if (isEmpty()) {
            head = node;
        } else {
            node.next =head;
            head = node;
        }
        length++;
        return true;
    }

    @Override
    public boolean addBack(T newEntry) {
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
    public boolean add(int newPosition, T newEntry) {
        //node object that stored value to be enter into list
        Node node = new Node(newEntry);

        //validation of newPosition
        if (validatePosition(newPosition)) {
            //add element at front if the list is empty
            if (isEmpty() || newPosition == 1) {
                node.next = head;
                head = node;
                return true;
            } else {
                //finding the node before
                Node nodeBefore = head;
                for (int i = 1; i < newPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;		
                }
                node.next = nodeBefore.next;	// make new node point to current node at newPosition
                nodeBefore.next = node;
                return true;
            }
        }
        length++;
        return false;

    }

    private boolean validatePosition(int newPosition) {
        return newPosition >= 1 && newPosition <= length + 1;
    }

    @Override
    public T remove(int givenPosition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        length = 0;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T getEntry(int givenPosition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(T anEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return false;
    }

}
