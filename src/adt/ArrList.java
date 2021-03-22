
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
    /*private final static int Current_Size = 5;
    private int length;
    private T[] array;
    private int numberOfEntries;
    
    public ArrList(){
        array = (T[]) new Object[Current_Size];
        numberOfEntries = 0;
    }
    
    @Override
    public void doubleArray(){
        T[] oldArray = array;
        array = (T[]) new Object[oldArray.length * 2];
        for (int i = 0; i < length; i++){
            array[i] = oldArray[i];
        }
    }

    @Override
    public boolean addAt(int newPosition, T newEntry) {
        boolean isSuccessful = true;
        
        if((newPosition >= 1) && (newPosition <= length +1)){
            makeRoom(newPosition);
            array[newPosition - 1] = newEntry;
            length++;
        
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }

    @Override
    public T remove(int givenPosition) {
    //T result = null;
    if(!isEmpty()){
    if ((givenPosition >= 1) && (givenPosition <= length)) {
      T removedEntry = array[givenPosition - 1];
      /*might not need because i want it to leave a gap and refill later length--;
      this loop is to shift the array which i might not need
      for(int i = givenPosition; i < numberOfEntries; i ++){
      array[i-1] = array[i] }
      
      if (givenPosition < length) {
        removeGap(givenPosition);
      }
      
        private void removeGap(int givenPosition) {
    // move each entry to next lower position starting at entry after the
    // one removed and continuing until end of array
    int removedIndex = givenPosition - 1;
    int lastIndex = length - 1;

    for (int index = removedIndex; index < lastIndex; index++) {
      array[index] = array[index + 1];
    }
  }

        //add new comment whole thign symbol here
      length--;
    }
    }

    return null;
    }

    @Override
    public boolean swap(int frontPosition, int backPosition) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        length = 0;
    }

    @Override
    public boolean replace(int givenPosition, T newEntry) {
    boolean isSuccessful = true;
     
    if ((givenPosition >= 1) && (givenPosition <= length)) {
      array[givenPosition - 1] = newEntry;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
    }

    @Override
    public T getEntry(int givenPosition) {
    
        if(!isEmpty())
            if ((givenPosition >= 1) && (givenPosition <= length)) {
            return array[givenPosition - 1];
    }
        return null;

    }

    @Override
    public boolean contains(T anEntry) {
    boolean found = false;
       for (int index = 0; !found && (index < length); index++) {
      if (anEntry.equals(array[index])) {
        found = true;
      }
    }
    return found;
    }


  @Override
  public int getLength() {
    return length;
  }

  @Override
  public boolean isEmpty() {
    return length == 0;
  }

  @Override
  public boolean isFull() {
    return false;
  }
  
  @Override
  public void makeRoom(int newPosition) {
    int newIndex = newPosition - 1;
    int lastIndex = length - 1;

    // move each entry to next higher index, starting at end of
    // array and continuing until the entry at newIndex is moved
    for (int index = lastIndex; index >= newIndex; index--) {
      array[index + 1] = array[index];
    }
}

    //this two might not be utilize
    @Override
    public boolean addFront(T newEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addBack(T newEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/

    
    private int size = 0;
    private int current;
    private T[] array;
    private static int DEFAULT_CAPACITY =10;
    private static int DEFAULT_ERROR_CODE =-1;
    private static int FACTOR = 2;

    
        // Create an empty ArrayList of Object type T with DEFAULT_CAPACITY 
    public ArrList(){
        array = (T[]) new Object[DEFAULT_CAPACITY];

}
    
    public ArrList(int capacity){
	size = 0;
	current = 0;
	array = (T[]) new Object[capacity];
	}
    
    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException {
		if(index>=0 || index<array.length){
			if(index<this.size){
				if(this.size==array.length)grow();
				for(int i = this.size-1;i>=index;i--){
					array[i+1]=array[i];
					}
				array[index]=element;
				size++;
			}	}
		else if(index==array.length){
			add(element);
			}
			else throw new IndexOutOfBoundsException();
			}

    //If ArrayList is full will then use the 'grow' to increase size , add element to list at end and update size 
    public void add(T element) {
        T[] oldArray = array;
        array = (T[]) new Object[oldArray.length * 2];
        
       //CAN BE SIZE OR CURRENT 
        for (int i = 0; i < size; i++){
            array[i] = oldArray[i];
        }
    }

   //FACTOR value allow me to control how much larger i want the array to grow rather than just double the array
    public void grow(){
	int numElements = this.size;
	int arrayLength = array.length;
	T[] tempArray = (T[])new Object[FACTOR*arrayLength];
	for(int i=0;i<this.size;i++){
		tempArray[i] = array[i];	
		}
	array = tempArray;
}

    //index is valid then shift the elements back from index to end make last element null, update the size and return the element at index*/ 
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if(index<0 || index>=this.size) throw new IndexOutOfBoundsException();
		T returnElement = array[index];
		for(int i = index+1;i<this.size;i++){
			array[i-1]=array[i];
			}
		array[this.size]=null;
		this.size--;
		return returnElement;
    }

    //Return the element at specified index if index is valid
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
		if(index<0 || index>=this.size) throw new IndexOutOfBoundsException();
		return array[index];
    }

    
    //Replace the element at specified index with specified element
    @Override
    public void set(int index, T element) throws IndexOutOfBoundsException {
 		if(index>=this.size) throw new IndexOutOfBoundsException();
		T returnElement = array[index];
		array[index]=element;
		
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    
    //find the first existence of element specified and if exist return its index if it is not then return DEFAULT_ERROR_CODE;
    @Override
    public int find(T element) {
		int returnIndex = DEFAULT_ERROR_CODE;
		for(int i=0;i<this.size;i++){
			if(array[i].equals(element)){
				returnIndex = i;
				break;
				}
			}
		return returnIndex;
    }

}
