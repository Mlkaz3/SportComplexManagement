package adt;

public interface ArrayStackInterface<T> {
    
    void push(T newEntry);
    
    T peek();
    
    T pop();
    
    boolean isEmpty();
    
    void clear();
    
    boolean isFull();
    
    int size();
    
    int length();
    
    
}
