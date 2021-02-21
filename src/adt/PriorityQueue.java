/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author YJ
 */
public class PriorityQueue<T> implements PriorityQueueInterface<T> {

    private T[] array;
    private int numOfElements;
    private int priority;
    private final static int DEFAULT_CAPACITY = 20;

    public PriorityQueue() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        numOfElements = 0;
    }

    @Override //Modify to add element based on priority
    public void joinQueue(T newElement) {
        boolean exist = contains(newElement);
        if (!exist) {
            array[numOfElements++] = newElement;
        }
    }

    @Override
    public void leaveQueue(T anElement) {
        if (contains(anElement)) {
            int i = 0;
            boolean found = false;
            while (i < numOfElements && !found) {
                if (array[i].equals(anElement)) {
                    found = true;
                } else {
                    i++;
                }
            }
            numOfElements--;
            for (int j = i; j < numOfElements; j++) {
                array[j] = array[j + 1];
            }
        }
    }

    private boolean contains(T newElement) {
        boolean exist = false;
        int i = 0;
        while (i < numOfElements && !exist) {
            if (array[i].equals(newElement)) {
                exist = true;
            } else {
                i++;
            }
        }
        return exist;
    }

    @Override
    public void serveFirst() {
        if (numOfElements != 0) {
            numOfElements--;
            for (int j = 0; j < numOfElements; j++) {
                array[j] = array[j + 1];
            }
        }
    }

//    @Override
//    public void compare(T newElement) {
//        int position = 0;
//        for (int i = 0; i < numOfElements; i++) {
//            if (newElement.toString().charAt(0) < array[i].toString().charAt(0)) {
//                position = i;
//            }
//        }
//        makeRoom(position);
//        array[position - 1] = newElement;
//        numOfElements++;
//    }
//    
//    private void makeRoom(int newPosition) {
//    int newIndex = newPosition - 1;
//    int lastIndex = numOfElements - 1;
//
//    for (int index = lastIndex; index >= newIndex; index--) {
//      array[index + 1] = array[index];
//    }
//  }
    
    @Override
    public boolean isEmpty() {
        return numOfElements == 0;
    }

    @Override
    public int getTotalEntry() {
        return numOfElements;
    }

    @Override //KIV because can use custom comparator to identify priority when enqueuing element
    public void cutQueue(T newElement, int position, int priority) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPosition(T anElement) {
        int position = 0;
        if (contains(anElement)) {
            int i = 0;

            boolean found = false;
            while (i < numOfElements && !found) {
                if (array[i].equals(anElement)) {
                    position = i + 1;
                    found = true;
                } else {
                    i++;
                }
            }
            return position;
        }
        return 0;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < numOfElements; i++) {
            str += (i + 1) + ". " + array[i] + "\n";
        }
        return str;
    }
}
