package adt;

import java.util.Iterator;

public interface ArrayStackWithIteratorInterface<T> extends StackInterface<T> {
    
    public Iterator<T> getIterator();
}
