package testcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import calculator.EmptyStackException;
import calculator.Entry;
import calculator.Stack;
import calculator.Symbol;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Class used to test and develop the Stack class using TDD.
 * 
 * @author Gilberto Pestana
 * @see    Stack
 */
public class TestStack {
  Stack testedStack;
  Stack testedStackWithEntry;
  
  //@Rule is used to test the expected exception on test 24.
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  /**
   * This Method is ran before each test. I create this method after test 16.
   */
  @Before
  public void createAStack() {
    testedStack = new Stack();
    testedStackWithEntry = new Stack();
    testedStackWithEntry.push(new Entry(5f));
  }
  
  /**
   * Test 16: Test if a Stack exists.
   * <p>to pass: I created the class Stack and a Constructor.</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void createStack() {
    Stack newStack = new Stack();
  }
  
  /**
   * Test 17: Test if a Stack is Empty.
   * <p>To pass: I created the method isEmpty() and made it return true.</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testEmpty() {
    assertTrue("error: a just created Stack is not empty",testedStack.isEmpty());
  }
  
  
  /**
   * Test 18: Test if we can push thing into the stack.
   * <p>To pass: I created the method <code>push()</code>.</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testPush() {
    testedStack.push(new Entry("something"));
  }
  
  /**
   * Test 19: Test if a Stack with a value pushed is empty.
   * <p>To pass: I had to create a field "size", make the method push to increment
   *          "size" and make <code>isEmpty()</code> to return if size is equals to 0</p>
   * @author Gilberto Pestana
   */
  @Test
  public void testPushThenIsEmpty() {
    assertFalse("error: a Stack with a value pushed is empty",testedStackWithEntry.isEmpty());
  }
  
  /**
   * Test 20:    Test if an empty stack has size 0.
   * <p>To pass: I create a method <code>size()</code> that returns the field "size".</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testSizeOfEmptyStack() {
    assertEquals("error size of empty stack different than 0", 0, testedStack.size());
  }
  
  /**
   * Test 21:    Test if pop() exist and if it decreases the size of Stack.
   * <p>To pass: I had to create the method <code>pop()</code> and make it 
   *             decrease the Stack size.</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testSizeOfPushThenPop() {
    try {
      testedStackWithEntry.pop();
    } catch (EmptyStackException e) {
      assertTrue("this exception shouldn't rise because Stack is not empty", false);
      e.printStackTrace();
    }
    assertEquals("error: push-pop doesn't return expecte size", 0, testedStack.size());
  }
  
  /**
   * Test 22: Test if <code>pop()</code> return the latest <code>Entry</code> pushed.
   * <p>To pass: I had to change push's constructor to make it accept one parameter of type Entry,
   *          I had to create a field "stack" of type ArrayList
   *          Then, make the parameter passed from push(Entry) be added to the "stack" ArrayList,
   *          and Finally, make pop return the latest Entry on the "stack" and remove it.
   *          Also, i had to change previous tests since <code>push()</code> 
   *          didn't need parameters.</p>
   *          
   * @author Gilberto Pestana
   */
  @Test
  public void testReturnFromPushPop() {
    Entry popedEntry;
    try {
      popedEntry = testedStackWithEntry.pop();
      assertEquals("error poped Entry is different than expected", new Entry(5f), popedEntry);
    } catch (EmptyStackException e) {
      assertTrue("this exception shouldn't rise because Stack is not empty", false);
      e.printStackTrace();
    }
    
  }
  
  /**
   * Test 23: Test whether popped <code>Entry()</code> are returned in the right order.
   * <p>To pass: I had not to change the code.</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testManyPushesManyPops() {
    Entry[] toBePush = {new Entry(5f), new Entry(Symbol.DIVIDE), new Entry("something")};
    Entry[] expectedPops = {new Entry("something"), new Entry(Symbol.DIVIDE), new Entry(5f)};
    for (Entry entry : toBePush) {
      testedStack.push(entry);
    }
    for (Entry expected: expectedPops) {
      try {
        assertEquals("error popped Entry different than expected",expected,testedStack.pop());
      } catch (EmptyStackException e) {
        assertTrue("this exception shouldn't rise because Stack is not empty", false);
        e.printStackTrace();
      }
    }
  }
  
  /**
   * Test 24:    Test whether we can call <code>pop()</code> from a empty list.
   * <p>To pass: I had to create a EmptyStackException and make pop throw it when size is 0.
   *             Also, I had to add try/catch statement on previous tests.</p>
   * 
   * @author Gilberto Pestana
   * @throws EmptyStackException throws an exception when trying to pop from an empty stack
   */
  @Test
  public void testPopFromEmptyStack() throws EmptyStackException {
    thrown.expect(EmptyStackException.class);
    thrown.expectMessage("not possible to call pop() on an empty Stack");
    testedStack.pop(); 
  }
  
  /**
   * Test 25:    Test whether we can view the latest Entry without deleting it.
   * <p>To pass: I created the method <code>top()</code> and made 
   *             it return the Entry on position size - 1</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testTop() {
    Entry pushed = new Entry(90f);
    testedStack.push(pushed);
    Entry entryOnTop;
    try {
      entryOnTop = testedStack.top();
      assertEquals("error Entry return from top() not expected",pushed,entryOnTop);
    } catch (EmptyStackException e) {
      assertTrue("this exception shouldn't rise because Stack is not empty", false);
      e.printStackTrace();
    }
  }
  
  /**
   * Test 26: Test if top and pop return the same value. knowing that top won't remove it.
   * <p>To pass: I didn't have to change the code.</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testTopEntryEqualsPopEntry() {
    Entry pushed = new Entry(Symbol.DIVIDE);
    testedStack.push(pushed);
    
    try {
      Entry entryOnTop = testedStack.top();
      Entry entryPopped = testedStack.pop();
      assertEquals("error Entry return from top() not expected",entryOnTop,entryPopped);
    } catch (EmptyStackException e) {
      assertTrue("this exception shouldn't rise because Stack is not empty", false);
      e.printStackTrace();
    }  
  }
  
  /**
   * Test 27: Test if we can call teh method <code>top()</code> from an empty stack.
   * <p>To pass: I made <code>top()</code> throw an EmptyStackException if 
   *             it's called when Stack is empty.</p>
   * 
   * @author Gilberto Pestana
   * @throws EmptyStackException needed to check the test.
   */
  @Test
  public void testTopFromEmptyStack() throws EmptyStackException {
    thrown.expect(EmptyStackException.class);
    thrown.expectMessage("not possible to call top() on an empty Stack");
    testedStack.top(); 
  }
  
  
  
}
