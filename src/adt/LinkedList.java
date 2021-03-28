package adt;

import java.io.Serializable;
import java.util.Iterator;

/**
 * @author 
 * Winnie Yap Xiang Loo 19WMR11981
 * @param <T>
 */

public class LinkedList<T> implements ListInterface<T>, Serializable {

    private Node head;
    private int length;

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
            status = true;
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
        Node node = new Node(newEntry);
        boolean isSuccessful = true;

        if (validatePosition(newPosition)) {
            if (isEmpty() || newPosition == 1) {
                node.next = head;
                head = node;
            } else {
                Node nodeBefore = head;
                for (int i = 1; i < newPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;
                }
                node.next = nodeBefore.next;
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

        if (validatePosition(givenPosition)) {
            if (givenPosition == 1) {
                removedNode = head;
                head = head.next;
            } else {

                Node nodeBefore = head;
                for (int i = 1; i < givenPosition - 1; ++i) {
                    nodeBefore = nodeBefore.next;
                }
                removedNode = nodeBefore.next;
                nodeBefore.next = removedNode.next;
            }
            removedEntry = (T) removedNode.data;
            length--;
        }

        return removedEntry;
    }

    @Override
    public void clear() {
        length = 0;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isReplaced = true;

        if (validatePosition(givenPosition)) {

            //finding the node before to be removed
            Node nodeReplace = head;
            for (int i = 1; i <= givenPosition - 1; i++) {
                nodeReplace = nodeReplace.next;
            }
            nodeReplace.data = newEntry;

        } else {
            isReplaced = false;
        }
        return isReplaced;
    }

    @Override
    public T getEntry(int givenPosition) {
        T entry = null;
        Node entryNode = null;

        if (validatePosition(givenPosition)) {
            Node nodeBefore = head;
            for (int i = 1; i <= givenPosition - 1; ++i) {
                nodeBefore = nodeBefore.next;
            }
            entryNode = nodeBefore;
            entry = (T) entryNode.data;
        }
        return entry;
    }

    @Override
    public boolean contains(T anEntry) {

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
        return false;
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
    public boolean swap(int frontPosition, int backPosition) {
        boolean status = false;
        T frontEntry = null;
        T backEntry = null;

        if (validatePosition(frontPosition) && validatePosition(backPosition)) {
            frontEntry = getEntry(frontPosition);
            backEntry = getEntry(backPosition);
            replace(frontPosition, backEntry);
            replace(backPosition, frontEntry);
            status = true;
        }
        return status;
    }

    @Override
    public int getPosition(T anEntry) {
        if (contains(anEntry) != true) {
            return -1;
        }
        boolean found = false;
        Node currentNode = head;
        int count = 1;
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

    @Override
    public T getLast() {
        T entry = null;
        Node entryNode = null;
        if (!isEmpty()) {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            entryNode = currentNode;
            entry = (T) entryNode.data;
        }
        return entry;
    }

    private class Node<T> implements Serializable {

        T data;
        Node next;

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
