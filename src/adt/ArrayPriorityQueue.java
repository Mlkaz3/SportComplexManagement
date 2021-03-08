/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author YJ
 */
public class ArrayPriorityQueue<T extends Comparable<T>> implements PriorityQueueInterface<T> {

    private T[] array;
    private final static int frontIndex = 0;
    private int backIndex;
    private static final int DEFAULT_CAPACITY = 20;

    public ArrayPriorityQueue() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayPriorityQueue(int initialCapacity) {
        array = (T[]) new Comparable[initialCapacity];
        backIndex = -1;
    }

    @Override
    public void enqueue(T newElement) {
        if (!isFull()) {
            int i = 0;
            while (i < backIndex && newElement.compareTo(array[i]) > 0) {
                i++;
            }
            makeRoom(i + 1);
            backIndex++;
            array[i] = newElement;
        }
    }

    @Override
    public void dequeue() {
        T front = null;

        if (!isEmpty()) {
            front = array[frontIndex];

            for (int i = frontIndex; i < backIndex; ++i) {
                array[i] = array[i + 1];
            }

            backIndex--;
        }
    }

    @Override
    public T remove(int position) {
        T result = null;

        if ((position >= 1) && (position <= backIndex)) {

            result = array[position - 1];

            if (position < backIndex) {

                for (int j = position - 1; j < backIndex; j++) { //use circular array with dynamic front?
                    array[j] = array[j + 1];
                }
            }
            backIndex--;
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return frontIndex > backIndex;
    }

    @Override
    public boolean isFull() {
        return backIndex == array.length - 1;
    }

    @Override
    public int getPosition(T anElement) {
        int position = 0;
        if (contains(anElement)) {
            int i = 0;

            boolean found = false;
            while (i < backIndex && !found) {
                if (array[i].equals(anElement)) {
                    position = i + 1;
                    found = true;
                } else {
                    i++;
                }
            }
            return position;
        }
        return 0;
    }

    private boolean contains(T newElement) {
        boolean exist = false;
        int i = 0;
        while (i < backIndex && !exist) {
            if (array[i].equals(newElement)) {
                exist = true;
            } else {
                i++;
            }
        }
        return exist;
    }
    
    private void makeRoom(int newPosition) {
    int newIndex = newPosition - 1;
    int lastIndex = backIndex + 1;

    for (int index = lastIndex; index >= newIndex; index--) {
      array[index + 1] = array[index];
    }
  }

    @Override
    public T getFront() {
        T front = null;

        if (!isEmpty()) {
            front = array[frontIndex];
        }
        return front;
    }

    @Override
    public int getTotalEntry() {
        return backIndex - 1;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i <= backIndex; i++) {
            str += (i + 1) + ". " + array[i] + "\n";
        }
        return str;
    }

}
