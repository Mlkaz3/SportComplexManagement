package adt;

import java.util.Iterator;

public interface ArrayStackWithIteratorInterface<T> extends ArrayStackInterface<T> {
    
    public Iterator<T> getIterator();
}
