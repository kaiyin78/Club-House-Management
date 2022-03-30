/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADT;
import Entity.*;
import java.io.Serializable;
/**
 *
 * @author user
 */
public interface LinkedListInterface <T> {
    public boolean add(T newEntry);

    public boolean add(int newPosition, T newEntry); //yes

    public void clear();

    public T getEntry(int givenPosition); //yes

    public boolean isEmpty();

    public T remove(int givenPosition);//yes

    public int Getsize(); //yes

    public boolean replace(int givenPosition, T newEntry); //yes

    public boolean contains(T anEntry);//yes

    public boolean isFull();
    
    public int calculation(int givenPosition);

}