
package adt;

import java.io.Serializable;

/**
 *
 * @author andre
 */

/*        Badminton[a,b,c,d,e]
        Tennis[a,b,c,d,e]
*/
public class ArrList<T> implements ListInter<T>, Serializable {

  private T[] array;
  private int filledSize;
  private static final int DEFAULT_CAPACITY = 5;

  public ArrList() {
    this(DEFAULT_CAPACITY);
  }

  public ArrList(int initialCapacity) {
    filledSize = 0;
    array = (T[]) new Object[initialCapacity];
  }

  @Override
  public boolean add(T newEntry) {
    array[filledSize] = newEntry;
    filledSize++;
    return true;
  }

  @Override
  public boolean add(int newPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= filledSize + 1)) {
        makeRoom(newPosition);
        array[newPosition - 1] = newEntry;
        filledSize++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
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
  public T getEntry(int atPosition) {
    T result = null;

    if ((atPosition >= 1) && (atPosition <= filledSize)) {
      result = array[atPosition - 1];
    }

    return result;
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
  public int getfilledSize() {
    return filledSize;
  }

  @Override
  public boolean isEmpty() {
    return filledSize == 0;
  }

  @Override
  public boolean isFull() {
    return false;
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

    // move each entry to next higher index, starting at end of
    // array and continuing until the entry at newIndex is moved
    for (int index = lastIndex; index >= newIndex; index--) {
      array[index + 1] = array[index];
    }
  }

  private void removeGap(int atPosition) {
    // move each entry to next lower position starting at entry after the
    // one removed and continuing until end of array
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
public T get(int index) throws IndexOutOfBoundsException {
    if(index<0 || index>=this.filledSize) throw new IndexOutOfBoundsException();
    return array[index];
    }

}
