package adt;

import java.io.Serializable;

/**
 *
 * @author Chen Chee Yong 19WMR11909
 */
public class ArrList<T> implements ListInter<T>, Serializable {

    private T[] array;
    private int filledSize;
    private int totalSize = 5;
    private static final int DEFAULT_CAPACITY = 10;
    private static int FACTOR = 2;

    public ArrList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrList(int initialCapacity) {
        filledSize = 0;
        array = (T[]) new Object[initialCapacity];
    }

    @Override
    public void add(T newEntry) {

        if (this.filledSize == array.length) {
            grow();
        }
        array[filledSize] = newEntry;
        filledSize++;
    }

    @Override
    public void add(int newPosition, T newEntry) {

        if (newPosition >= 0 || newPosition < array.length) {
            if (newPosition < this.filledSize) {
                if (this.filledSize == array.length) {
                    grow();
                }
                for (int i = this.filledSize - 1; i >= newPosition; i--) {
                    array[i + 1] = array[i];
                }
                array[newPosition] = newEntry;
                filledSize++;
            }
        } else if (newPosition == array.length) {
            add(newEntry);
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    @Override
    public T remove(int atPosition) {
        T result = null;

        if ((atPosition >= 1) && (atPosition <= filledSize)) {
            result = array[atPosition - 1];

            if (atPosition < filledSize) {
                removeGap(atPosition);
            }

            filledSize--;
        }

        return result;
    }

    @Override
    public void clear() {
        filledSize = 0;
    }

    @Override
    public boolean replace(int atPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((atPosition >= 1) && (atPosition <= filledSize)) {
            array[atPosition - 1] = newEntry;
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    @Override
    public boolean contains(T position) {
        boolean found = false;
        for (int index = 0; !found && (index < filledSize); index++) {
            if (position.equals(array[index])) {
                found = true;
            }
        }
        return found;
    }

    @Override
    public boolean isEmpty() {
        return filledSize == 0;
    }

    @Override
    public String toString() {
        String outputStr = "";
        for (int index = 0; index < filledSize; ++index) {
            outputStr += array[index] + "\n";
        }
        return outputStr;
    }

    private void makeRoom(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = filledSize - 1;

        for (int index = lastIndex; index >= newIndex; index--) {
            array[index + 1] = array[index];
        }
    }

    private void removeGap(int atPosition) {
        int removedIndex = atPosition - 1;
        int lastIndex = filledSize - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
    }

    @Override
    public int filledSize() {
        return filledSize;
    }

    @Override
    public T get(int atPosition) throws IndexOutOfBoundsException {
        T result = null;

        if ((atPosition >= 1) && (atPosition <= filledSize)) {
            result = array[atPosition - 1];
        }

        return result;
    }

    private void grow() {
        int numElements = this.filledSize;
        int arrayLength = array.length;
        T[] tempArray = (T[]) new Object[FACTOR * arrayLength];
        for (int i = 0; i < this.filledSize; i++) {
            tempArray[i] = array[i];
        }
        array = tempArray;
    }

}
