package adt;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author 
 * Chan Mei Hui 19WMR11908
 */

public class ArrayStack<T> implements ArrayStackWithIteratorInterface<T>, Serializable {

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
    //adding new entry to stack
    public void push(T newEntry) {
        topIndex++; //Increment topIndex value

        if (!isFull()) {// check if the array is full,proceed to adding only when its not full
                array[topIndex] = newEntry;  //assigning the new entry value at the location indicated by topIndex  
        } else {
            //System.out.println("Stack capcity expanded.");
            expandCapacity();                 //expand array when its full
            array[topIndex] = newEntry;
        }
    }

    @Override
    //remove element from stack
    public T pop() {
        //declaring temporary variable 
        T top = null;

        if (!isEmpty()) {
            top = array[topIndex];  //assign the value at topIndex to the declared temporary variable
            array[topIndex] = null; // set value to null (optional), decrementing topIndex value is like "detatching" 
            topIndex--; //decrement topIndex value
        }

        return top; // return to client program when called
    }

    @Override
    //return the top element without removing it
    public T peek() {
        //declaring temporary variable
        T top = null;

        if (!isEmpty()) {
            top = array[topIndex]; //assign the value at topIndex to the declared temporary variable
        }

        return top; //return to client program when called
    }

    @Override
    //check if the stack is an empty stack
    public boolean isEmpty() {
        return topIndex < 0;
    }

    @Override
    //check if the stack is full
    public boolean isFull() {
        if (topIndex < array.length) {
            return false;
        }
        return true;
    }

    @Override
    //clear all elements in the stack
    public void clear() {
        topIndex = -1;
    }

    @Override
    //return size of the stack(no. of current elements in stack)
    public int size() {
        return topIndex + 1;
    }

    @Override
    //return length of the array stack (the number of elements it can hold)
    public int length() {
        return this.array.length;
    }

    //--------------------------UTILITY METHODS --------------------------------
    //expand size of the array stack
    private void expandCapacity() {
        T[] expanded = (T[]) new Object[array.length * 2]; //create a new array with double the size of original array

        for (int i = 0; i < array.length; i++) {
            expanded[i] = array[i]; //copy the corresponding elements from old array to expanded array
        }
        array = expanded; //array reference is now pointing to the exapnded array
    }

    @Override
    public boolean contains(T newEntry) {
        //boolean contains = false;
        Iterator<T> iterator = getIterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(newEntry)) //contains = true;
            {
                return true;
            }
        }
        //return contains;
        return false;
    }

    @Override
    public Iterator<T> getIterator() {
        return new StackIterator();
    }

    //iterator class
    private class StackIterator implements Iterator<T> {

        private int iteratorIndex = 0;

        @Override
        // Check if the array stack has next element or not
        public boolean hasNext() {
            return iteratorIndex < size();
        }

        @Override
        // Retrieve the value of next element
        public T next() {
            if (hasNext()) {
                return array[iteratorIndex++];
            } else {
                throw new NoSuchElementException("Illegal call to next();"
                        + "iterator is after end of list.");
            }
        }
    }
}
