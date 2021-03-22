/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import entity.Facility;

/**
 *
 * @author andre
 */
public interface ListInter<T> {
    

    
    //Add an element to the list at specified index, resize if needed
    void add(int index,T element) throws IndexOutOfBoundsException;

    //Remove an element from specified index if valid and return the removed element
    T remove(int index) throws IndexOutOfBoundsException;

    //Return the element at specified index if valid
    T get(int index) throws IndexOutOfBoundsException;

    //Replace the element at specified index in list with specified element by user if index is valid
    void set(int index, T element) throws IndexOutOfBoundsException;

    //Return the number of elements in the list
    int size();

    //Return a boolean whether the list is empty
    boolean isEmpty();

    //Return the index of first occurence of specified element if it exists in the list
    int find(T element);
    

    
     /*   
    void doubleArray();
    boolean addAt(int newPosition, T newEntry);
    T remove(int givenPosition);
    void clear();
    boolean replace(int givenPosition, T newEntry);
    T getEntry(int givenPosition);
    int getLength();
    boolean isEmpty();
    boolean isFull();
    void makeRoom(int newPosition);
    boolean addFront(T newEntry);
    public boolean addBack(T newEntry);
    boolean contains(T anEntry);
    boolean swap(int frontPosition, int backPosition);
    //void makeRoom(int newPosition);
    //void add(T newEntry); */

   // public void add(Facility badmintonCourt1);
    

}
