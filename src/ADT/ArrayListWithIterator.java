/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

/**
 *
 * @author Lim Keng Yik
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayListWithIterator<T> implements ListWithIteratorInterface<T> {

  private T[] bookingarray;
  private int length;
  private static final int DEFAULT_CAPACITY = 50;


  
  
  public ArrayListWithIterator() {
    this(DEFAULT_CAPACITY);
  }

  public ArrayListWithIterator(int initialCapacity) {
    length = 0;
    // the cast is safe because the new array contains null entries
    @SuppressWarnings("unchecked")
    T[] tempList = (T[]) new Object[initialCapacity];
    bookingarray = tempList;
  }

  @Override
  public Iterator<T> getIterator() {
    return new IteratorForArrayList();
  }

 

  //Correct liao!!!
  @Override
    public boolean add(T newEntry){
    bookingarray[length] = newEntry;
    length++;
    return true;
  }

    //Correct liao!!!
  @Override
  public boolean add(int newPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= length + 1)) {
      if (!isArrayFull()) {
        makeRoom(newPosition);
        bookingarray[newPosition - 1] = newEntry;
        length++;
        
      }
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  //Correct liao!!!
  @Override
  public T remove(int givenPosition) {
    T result = null;

    if (givenPosition <= length) {
      result = bookingarray[givenPosition];
    

      if (givenPosition < length) {
        removeGap(givenPosition);
      }

      length--;
    }

    return result;
  }

  
  @Override
  public void clear() {
    length = 0;
  }

   
  //COrrect liao!!!
  @Override
  public boolean replace(int givenPosition, T newEntry) {
    boolean isSuccessful = true;

    if (givenPosition <= length) {
      bookingarray[givenPosition] = newEntry;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  
 
  //Correct liao!!!
  @Override
  public T getEntry(int givenPosition) {
    T result = null;

    if (givenPosition <= length) {
      result = bookingarray[givenPosition];
    }

    return result;
  }

  //Correct liao!!!
  @Override
  public boolean contains(T anEntry) {
    boolean found = false;
    for (int index = 0;index < length; index++) {
      if (anEntry.equals(bookingarray[index])) {
        found = true;
      }
    }

    return found;
  }

  //Correct liao!!!
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
  public String toString() {
    String outputStr = "";
    for (int index = 0; index < length; ++index) {
      outputStr += bookingarray[index] + "\n";
    }

    return outputStr;
  }

 
  private boolean isArrayFull() {
    return length == bookingarray.length;
  }

  /**
   * Task: Makes room for a new entry at newPosition. Precondition: 1 <=
   * newPosition <= length + 1; length is array's
 length before addition.
   */
  private void makeRoom(int newPosition) {
    int newIndex = newPosition - 1;
    int lastIndex = length - 1;

    for (int index = lastIndex; index >= newIndex; index--) {
      bookingarray[index + 1] = bookingarray[index];
    }
  }

  /**
   * Task: Shifts entries that are beyond the entry to be removed to the next
   * lower position. Precondition: array is not empty; 1 <= givenPosition <
 length; length is array's length before removal.
   */
  private void removeGap(int givenPosition) {
    int removedIndex = givenPosition;
    int lastIndex = length - 0;

    for (int index = removedIndex; index < lastIndex; index++) {
      bookingarray[index] = bookingarray[index + 1];
    }
  }
  
  
  
  
  

  private class IteratorForArrayList implements Iterator<T> {

    private int nextIndex;
    private boolean wasNextCalled; // needed by remove

    private IteratorForArrayList() {
      nextIndex = 0;
      wasNextCalled = false;
    }

    @Override
    public boolean hasNext() {
      return nextIndex < length;
    }

    @Override
    public T next() {
      if (hasNext()) {
        wasNextCalled = true;
        T nextEntry = bookingarray[nextIndex];
        nextIndex++; // advance iterator

        return nextEntry;
      } else {
        throw new NoSuchElementException("Illegal call to next();"
                + "iterator is after end of list.");
      }
    }

    @Override
    public void remove() {
      if (wasNextCalled) {
        // nextIndex was incremented by the call to next, so it 
        // is the position number of the entry to be removed
        ArrayListWithIterator.this.remove(nextIndex);
        nextIndex--;           // index of next entry in iteration
        wasNextCalled = false; // reset flag
      } else {
        throw new IllegalStateException("Illegal call to remove(); "
                + "next() was not called.");
      }
    }
    
  }
  }
  