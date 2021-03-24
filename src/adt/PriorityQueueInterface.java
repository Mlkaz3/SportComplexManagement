/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author YJ
 * @param <T>
 */
public interface PriorityQueueInterface<T extends Comparable<T>> {
    
    boolean enqueue (T newElement);
    
    T dequeue();
    
    boolean remove(T anElement);
    
    T getFront();
    
    int getTotalEntry();
    
    boolean isEmpty();
    
    int getPosition(T anElement);
    
    T getElement(int position);
    
    void clear();
    
    void desc();
    
    boolean contains(T newElement);
}

    //T remove(int position);