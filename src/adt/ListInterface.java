package adt;

/**
 * @author 
 * Winnie Yap Xiang Loo 19WMR11981
 * @param <T>
 */

public interface ListInterface<T> {

    public boolean addFirst(T newEntry);

    public boolean addLast(T newEntry);

    public boolean addAt(int newPosition, T newEntry);

    public T removeAt(int givenPosition);

    public boolean swap(int frontPosition, int backPosition);

    public void clear();

    public boolean replace(int givenPosition, T newEntry);

    public T getEntry(int givenPosition);
    
    public T getLast();

    public int getPosition(T newEntry);

    public boolean contains(T anEntry);

    public int getLength();

    public boolean isEmpty();

    public boolean isFull();
    

}
