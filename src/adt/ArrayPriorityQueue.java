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
    public boolean enqueue(T newElement) {
        boolean successful = true;

        if (!isFull() && !duplicated(newElement)) {
            int i = 0;
            while (i <= backIndex && newElement.compareTo(array[i]) > 0) {
                i++;
            }
            makeRoom(i);
            backIndex++;
            array[i] = newElement;
        } else {
            successful = false;
        }
        return successful;
    }

    @Override
    public T dequeue() {
        T front = null;
        if (!isEmpty()) {
            front = array[frontIndex];
            shiftFront();
            backIndex--;
        }
        return front;
    }

    @Override
    public T remove(int position) {
        T result = null;
        if (!isEmpty() && (position >= 1) && (position <= backIndex + 1)) {
            result = array[position - 1];
            if (position - 1 < backIndex) {
                removeGap(position);
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
    public T getFront() {
        T front = null;
        if (!isEmpty()) {
            front = array[frontIndex];
        }
        return front;
    }

    @Override
    public int getTotalEntry() {
        return backIndex + 1;
    }

    private void makeRoom(int i) {
        for (int index = backIndex + 1; index >= i; index--) {
            array[index + 1] = array[index];
        }
    }

    private boolean duplicated(T newElement) {
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

    private void shiftFront() {
        for (int i = frontIndex; i < backIndex; ++i) {
            array[i] = array[i + 1];
        }
    }

    private void removeGap(int position) {
        for (int j = position - 1; j < backIndex; j++) {
            array[j] = array[j + 1];
        }
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

//    @Override
//    public int getPosition(T anElement) {
//        int position = 0;
//        if (contains(anElement)) {
//            int i = 0;
//            boolean found = false;
//            while (i < backIndex && !found) {
//                if (array[i].equals(anElement)) {
//                    position = i + 1;
//                    found = true;
//                } else {
//                    i++;
//                }
//            }
//            return position;
//        }
//        return 0;
//    }
