/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 * can do index of
 *
 * @author winnieyap
 * @param <T>
 */
public interface ListInterface<T> {

    public boolean addFirst(T newEntry);

    public boolean addLast(T newEntry);

    public boolean addAt(int newPosition, T newEntry);

    public T removeAt(int givenPosition);

    public boolean swap(int frontPosition, int backPosition);

    public void clear();

    public boolean replace(int givenPosition, T newEntry);

    public T getEntry(int givenPosition);
    
    public T getLast();

    public int getPosition(T newEntry);

    public boolean contains(T anEntry);

    public int getLength();

    public boolean isEmpty();

    public boolean isFull();
    

}
