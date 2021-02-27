/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import java.util.Comparator;

/**
 *
 * @author YJ
 */
public class SortedArrayPriorityQueue<T> implements Comparable<T>, PriorityQueueInterface<T> {
    private static final int SIZE = 10;

    private Comparator<? super T> comparator;
    private T[] array;
    private int count;

    public SortedArrayPriorityQueue() {
        
    }
    
    public SortedArrayPriorityQueue(Comparator<? super T> c) {
        comparator = c;
        array = (T[]) new Comparable[SIZE]; // No way to verify that 'list' only contains instances of 'T'.

        /* NOTE: Following is not allowed.
        list = new T[SIZE]; // Cannot create a generic array of T
        */
    }
    
    @Override
    public void enqueue(T element) {
        if (count == 0) {
            array[0] = element;
            count = 1;
        }
        else {
            if (!isFull()) {
                int i = 0;
                while (array[i] != null) {
                    if (element.compareTo(array[i]) < 0) {
                        break;
                    }
                    i++;
                }
                if (array[i] != null) {
                    for (int j = count - 1; j >= i; j--) {
                        array[j + 1] = array[j];
                    }
                }
                array[i] = element;
                count++;
            }
        }
    }
    
    @Override
    public boolean isFull() {
        return count == SIZE;
    }
    
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public T remove(int index) {
        T removed = array[index];
        array[index] = null;
        for (int i = index; i < count; i++) {
            array[i] = array[i + 1];
        }
        count--;
        array[count] = null;
        return removed;
    }

    @Override
    public int getTotalEntry() {
        return count;
    }

    
//    @Override
//    public void enqueue(T newElement) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void dequeue() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public T remove(int position) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean isEmpty() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean isFull() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int getPosition(T anElement) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public int getTotalEntry() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public int compareTo(T o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}