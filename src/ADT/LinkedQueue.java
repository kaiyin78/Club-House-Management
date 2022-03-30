
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;

import java.io.Serializable;
import Entity.*;

/**
 *
 * @author wong kai yin
 */
public class LinkedQueue<T>  implements QueueInterface<T>, Serializable {

    private T[] array;
    private final static int frontIndex = 0;
    private int backIndex;
    private static final int DEFAULT_CAPACITY = 50;

    public LinkedQueue() {
        this(DEFAULT_CAPACITY);
    }

    public LinkedQueue(int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
        backIndex = -1;
    }
 @Override
    public void enqueue(T newEntry) {
        if (!isArrayFull()) {
            backIndex++;
            array[backIndex] = newEntry;
        }
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
    public boolean testFront() {
        boolean test = false;
         T front = null;
   front = array[frontIndex];
test= true;

 return test;     
    }
 @Override
    public T dequeue() {
        T front = null;
        if (!isEmpty()) {
            front = array[frontIndex];
            // shift remaining array items forward one position
            for (int i = frontIndex; i < backIndex; ++i) {
                array[i] = array[i + 1];
            }
            backIndex--;
        }
        return front;
    }
    
     @Override
    public T dequeueBack(int givenPosition) {
    T front = null;
for (int i = 1; i <=backIndex; i++) {
        array[i] = array[--backIndex];

     front= array[i];

}
return front;
    }
    
    
    
    
    
   
 @Override
    public void clear() {
        if (!isEmpty()) { // deallocates only the used portion
            for (int index = frontIndex; index <= backIndex; index++) {
                array[index] = null;
            }

            backIndex = -1;
        }
    }
 @Override
    public boolean isEmpty() {
        return frontIndex > backIndex;
    }

    public T getBack(int index) {
        T result = null;

        if (index <= backIndex) {
            result = array[index];
        }

        return result;
    }
    
 @Override
    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;
        if (givenPosition <= backIndex) {
            array[givenPosition] = newEntry;
        } else {
            isSuccessful = false;
        }
        return isSuccessful;
    }
  
 @Override
    public boolean contains(T anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < backIndex + 1); index++) {
            if (anEntry.equals(array[index])) {
                found = true;
            }
        }
        return found;
    }
 
    public int findLargest(int[] anEntry) 
    {   
             int max = anEntry[0];              

        for (int i = 0;i <= backIndex; i++) {
             if(anEntry[i] > max){
                 max=anEntry[i];       
            } 
        }
        return max; 
    }      

    public int count(T anEntry) 
    {  int count = 0; 
        if(!isEmpty()){
     for (int i = frontIndex;i <= backIndex; i++) {     
       if(array[i]== anEntry){    
          count++;
       }
     }
        }
        return count; 
    } 
  public int calculation(int givenPosition, int SecondgivenPosition) 
    {  
    int sum=0;
    int total= givenPosition /SecondgivenPosition;  
      sum= givenPosition-total;
        return sum; 
    } 
 


    @Override
    public boolean isFull() {
        return false;
    }

    private boolean isArrayFull() {
        return backIndex == array.length - 1;
    }
    
    
@Override
public int getSize()
{
return backIndex+1;
}

 @Override
  public T getEntry(int givenPosition) {
    T result = null;

    if (givenPosition <= backIndex) {
      result = array[givenPosition];
    }

    return result;
  }
    
  
 
}
