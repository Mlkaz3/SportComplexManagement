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
public interface PriorityQueueInterface<T> {
    
    void enqueue (T newElement);
    
    void dequeue ();
    
    void remove (T anElement);
    
    boolean isEmpty();
    
    boolean isFull();
    
    int getPosition(T anElement);
    
    int getTotalEntry();
}
