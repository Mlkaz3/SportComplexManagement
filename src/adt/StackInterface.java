package adt;

import java.util.Iterator;

public interface StackInterface<T> {
    
    void push(T newEntry);
    
    T pop();
    
    T peek();
    
    boolean isEmpty();
    
    boolean isFull();
    
    void clear();

    int size();
    
    int length();
    
    boolean contains(T newEntry);
    
    Iterator<T> getIterator();
    
}
