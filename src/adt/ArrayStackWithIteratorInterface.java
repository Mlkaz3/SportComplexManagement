package adt;

import java.util.Iterator;

/**
 * @author 
 * Chan Mei Hui 19WMR11908
 */

public interface ArrayStackWithIteratorInterface<T> extends StackInterface<T> {
    
    public Iterator<T> getIterator();
}
