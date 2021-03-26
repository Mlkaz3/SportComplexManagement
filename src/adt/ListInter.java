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

  public void add(T newEntry);


  public void add(int newPosition, T newEntry);

  public T remove(int atPosition);

  public void clear();

  public boolean replace(int atPosition, T newEntry);

  public T getEntry(int atPosition);


  public boolean contains(T position);


  public int getfilledSize();


  public boolean isEmpty();

  public boolean isFull();
  
  public int filledSize();
  
  public T get(int index);
  
  //public void grow();

    public int size();
}


