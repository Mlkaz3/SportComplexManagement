/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author winnieyap
 * note: 
 * more function to be added 
 * some function to be removed based on it's usage 
 */
public interface ListInterface<T> {
    //add a new element
    //usage: normal adding
    boolean add(T newElement);
    
    //add a new element at given position
    //usage: ??
    boolean add(int givenPosition, T newElement);
    
    //replace the element at given position with a new element 
    //usage: when facilities/equipment reserved wrongly; when the reserved date is edited;
    boolean replace(int givenPosition, T newElement);
    
    //get an element at givenPosition
    //usage: ??
    ListInterface getElement(int givenPosition);
    
    //delete the whole record
    //usage: ??
    boolean delete();
    
    //delete a given element
    //usage: when reservation is canceled; when staff make mistakes;
    boolean delete(T anElement);
    
    //copy a given element
    //usage: ??
    boolean copy(T givenElement);
    
    //check wether the given element exist in the list of record
    //usage: ?? check duplication of user? 
    boolean contains(T givenElement);
    
    //check wether the list of record is empty
    //usage: ??
    boolean isEmpty();
    
    //check wether the list of record is full
    //usage: ???
    boolean isFull();
    
    //check the length of list of record
    //usage: ??? to analyse how many transaction in a day? 
    int getLength();
    
}
