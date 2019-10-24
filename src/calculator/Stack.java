package calculator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class uses the data structure List to store objects of type Entry.
 * 
 * @author  Gilberto Pestana
 * @see     Entry
 * @version 1.0, 10/20/2019
 * @since   1.0
 */
public class Stack {
  private List<Entry> entries;
  private int size;
  
  /**
   * Creates a Stack object.
   * 
   * @author Gilberto Pestana
   * @since  1.0
   */
  public Stack() {
    this.entries = new LinkedList<>();
    this.size = 0;
  }
  
  /**
   * Returns a boolean, "True" if Stack is empty "False" otherwise.
   * 
   * @author Gilberto Pestana
   * @return <code>true</code> if stack is empty <code>false</code> otherwise.
   * @since  1.0
   */
  public boolean isEmpty() {
    return this.size == 0;
  }
  
  /**
   * Adds a new Entry on top of the Stack.
   * 
   * @author           Gilberto Pestana
   * @param entryTaken the Entry to be added on top of the Stack
   * @since            1.0
   */
  public void push(Entry entryTaken) {
    size++;
    this.entries.add(entryTaken);
  }

  /**
   * returns how many <code>Entry</code> are stored in Stack.
   * 
   * @author Gilberto Pestana.
   * @return the size of Stack.
   * @since  1.0
   */
  public int size() {
    return this.size;
  }

  /**
   * returns the Entry on top of the Stack and deletes it,
   * if Stack is empty it throws and exception.
   * 
   * @author                     Gilberto Pestana
   * @return                     the Entry on top of the Stack.
   * @throws EmptyStackException rises when called and Stack is empty.
   * @since                      1.0
   */
  public Entry pop() throws EmptyStackException {
    if (this.size == 0) {
      throw new EmptyStackException("not possible to call pop() on an empty Stack");
    }
    size--;
    return entries.remove(this.size);
    
  }

  /**
   * returns the Entry on top of the Stack, if Stack is empty it throws and exception.
   * 
   * @author                     Gilberto Pestana
   * @return                     the Entry on top of the Stack.
   * @throws EmptyStackException rises when called and Stack is empty.
   * @since                      1.0
   */
  public Entry top() throws EmptyStackException {
    if (this.size == 0) {
      throw new EmptyStackException("not possible to call top() on an empty Stack");
    }
    return entries.get(this.size - 1);
  }


}
