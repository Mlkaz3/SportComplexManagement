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
            node.next = head;
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
        } else {
            isSuccessful = false;
        }
        length++;
        return isSuccessful;
    }

    @Override
    public T remove(int givenPosition) {
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

    private boolean validatePosition(int newPosition) {
        return newPosition >= 1 && newPosition <= length + 1;
    }

    @Override
    public String toString() {
        String outputStr = "";
        Node currentNode = head;
        while (currentNode != null) {
            outputStr += currentNode.data + "\n";
            currentNode = currentNode.next;
        }
        return outputStr;
    }

}
