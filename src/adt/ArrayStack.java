package adt;

import java.util.Iterator;

public class ArrayStack<T> implements ArrayStackInterface<T> {
    
    //Variable Declaration
    private T[] array; //to store the entries of the stack
    private int topIndex; // index of the top entry
    private static final int DEFAULT_CAPACITY = 20; //default size for array

   
    //Constructor for array stack with default size
    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }
    
    //constructor for array with given size
    public ArrayStack(int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
        topIndex = -1; //initialized to -1 to indicate an empty stack
    }
       

    @Override
    public void push(T newEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int length() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
