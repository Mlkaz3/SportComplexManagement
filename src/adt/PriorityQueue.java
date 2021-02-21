/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import entity.Facility;

/**
 *
 * @author YJ
 */
public class PriorityQueue<T> implements PriorityQueueInterface<T> {
    
    private T[] array;
    private int numOfEntries;
    private final static int DEFAULT_CAPACITY = 10;

    public PriorityQueue() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        numOfEntries = 0;
    }
    
    @Override //Modify to add element based on priority
    public void joinQueue(T newElement) {
        boolean exist = contains(newElement);
        if (!exist) {
            array[numOfEntries++] = newElement;
        }
    }

    private boolean contains(T newElement) {
        boolean exist = false;
        int i = 0;
        while (i < numOfEntries && !exist) {
            if (array[i].equals(newElement)) {
                exist = true;
            } else {
                i++;
            }
        }
        return exist;
    }

    @Override
    public void leaveQueue(T anElement) {
        if (contains(anElement)) {
            int i = 0;
            boolean found = false;
            while (i < numOfEntries && !found) {
                if (array[i].equals(anElement)) {
                    found = true;
                } else {
                    i++;
                }
            }
            numOfEntries--;
            for (int j = i; j < numOfEntries; j++) {
                array[j] = array[j + 1];
            }
        }
    }

    @Override
    public void serveFirst() {
        if (numOfEntries != 0) {
            numOfEntries--;
            for (int j = 0; j < numOfEntries; j++) {
                array[j] = array[j + 1];
            }
        }
    }

    @Override //KIV because can use custom comparator to identify priority when enqueuing element
    public void cutQueue(T newElement, int position, int priority) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int checkPosition(T anElement) {
       int position = 0;
       if (contains(anElement)) {
            int i = 0;
            
            boolean found = false;
            while (i < numOfEntries && !found) {
                if (array[i].equals(anElement)) {
                    position = i+1;
                    found = true;
                } else {
                    i++;
                }
            }
       }
       return position;
    }
    
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < numOfEntries; i++) {
        str += (i+1) + ". " + array[i] + "\n";
    }
        return str;
    } 
}
