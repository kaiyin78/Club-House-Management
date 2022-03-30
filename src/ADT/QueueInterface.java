/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;
//* @author wong kai yin
import Entity.*;
import java.io.Serializable;

public interface QueueInterface<T>{

    public void enqueue(T newEntry);
 public T dequeue();
  public T dequeueBack(int givenPosition);
 public boolean testFront();

    public T getFront();

    public void clear();

    public T getBack(int index);

    public boolean isEmpty();

    public boolean replace(int givenPosition, T newEntry); //yes

    public boolean contains(T anEntry);//yes

    public boolean isFull();

    public int getSize();
    
     public T getEntry(int givenPosition);
     
     public int count(T anEntry) ;
      
    public int calculation(int givenPosition, int SecondgivenPosition);
   
   public int findLargest(int[] anEntry) ;

}
