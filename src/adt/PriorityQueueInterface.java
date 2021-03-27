/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Ong Yi Jie 19WMR11855
 * @param <T>
 */
public interface PriorityQueueInterface<T extends Comparable<T>> {

    boolean enqueue(T newElement);

    T dequeue();

    boolean remove(T anElement);

    T getFront();

    int getTotalEntry();

    boolean isEmpty();

    T getElement(int position);

    void clear();

    boolean contains(T newElement);
}