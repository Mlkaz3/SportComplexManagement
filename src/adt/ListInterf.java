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
public interface ListInterf<T> {
    
    //add a new entry to the linked list
    public boolean addFront(T newEntry);
    
    //add a new entry to the linked list
    public boolean addBack(T newEntry);
    
    //add a new entry at given Position in the linked list
    public boolean addAt(int newPosition, T newEntry);
    
    //remove element at given position
    public T remove(int givenPosition);
    
    public void clear();
    public boolean replace(int givenPosition, T newEntry);
    public T getEntry(int givenPosition);
    public boolean contains(T anEntry);
    public int getLength();
    public boolean isEmpty();
    public boolean isFull();
    
}
