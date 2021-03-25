/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *can do index of 
 * @author winnieyap
 * @param <T>
 */
public interface ListInterface<T extends Comparable<T>> {
    
    //add a new entry to the linked list
    public boolean addFirst(T newEntry);
    
    //add a new entry to the linked list
    public boolean addLast(T newEntry);
    
    //add a new entry at given Position in the linked list
    public boolean addAt(int newPosition, T newEntry);
    
    //remove element at given position
    public T removeAt(int givenPosition);
    public T remove(T newEntry);
    public T removeLast();
    public T removeFirst();
    
    //to swap element that stick together
    public void swap(int frontPosition, int backPosition);
    
    public void clear();
    
    public boolean replace(int givenPosition, T newEntry);
    
    public T getEntry(int givenPosition);
    
    public boolean contains(T anEntry);
    
    public int getLength();
    
    public boolean isEmpty();
    
    public boolean isFull();
        
}
