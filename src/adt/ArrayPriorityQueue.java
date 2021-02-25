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
public class ArrayPriorityQueue<T> implements PriorityQueueInterface<T> {

    private T[] array;
    private int numOfElements; //Length of queue
    private final static int frontIndex = 0;
    private int backIndex;  
    private final static int DEFAULT_CAPACITY = 20; //Max number of maintenance schedules that can be made

    public ArrayPriorityQueue() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        numOfElements = 0;
    }

    @Override //Modify to add element based on priority
    public void enqueue(T newElement) {
        boolean exist = contains(newElement);
        if (!exist) {
            array[numOfElements++] = newElement;
            backIndex++;
        }
    }

    @Override
    public void dequeue() {
        if (numOfElements != 0) {
            numOfElements--;
            for (int j = 0; j < numOfElements; j++) {
                array[j] = array[j + 1];
            }
        }
    }

    @Override
    public void remove(T anElement) {
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
            for (int j = i; j < numOfElements; j++) { //use circular array with dynamic front?
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
    public boolean isEmpty() {
        return backIndex < frontIndex;
    } 
    
    @Override
    public boolean isFull() {
        return backIndex == array.length - 1;
    }

    @Override
    public int getTotalEntry() {
        return numOfElements;
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
