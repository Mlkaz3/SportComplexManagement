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
    
    void enqueue (T newElement);
    
    void dequeue ();
    
    T remove(int position);
    
    boolean isEmpty();
    
    boolean isFull();
    
    int getPosition(T anElement);
    
    T getFront();
    
    int getTotalEntry();
}