package adt;

import java.util.Iterator;

/**
 * @author 
 * Chan Mei Hui 19WMR11908
 */

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
