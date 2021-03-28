package adt;

/**
 *
 * @author Chen Chee Yong 19WMR11909
 */
public interface ListInter<T> {

  public void add(T newEntry);

  public void add(int newPosition, T newEntry);

  public T remove(int atPosition);

  public void clear();

  public boolean replace(int atPosition, T newEntry);

  public boolean contains(T position);

  public boolean isEmpty();

  public int filledSize();
  
  public T get(int atPosition);
}


