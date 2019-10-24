package testcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import calculator.BadTypeException;
import calculator.EmptyStackException;
import calculator.Entry;
import calculator.Symbol;
import calculator.Type;
import java.util.Random;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Class used to test and develop the Entry class using TDD.
 * 
 * @author Gilberto Pestana
 * @see    Entry
 */
public class TestEntry {
  Entry testedF;
  Entry testedS;
  Entry testedSt;
  Random rd;
  Entry testedFR; // Random Entry(float)
  Entry testedSR; // Random Entry(Symbol)
  Symbol[] allSymbols;
  
  // @Rule is used to test the expected exception on tests 14 and 15.
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  /**
   * I was creating Entry()s for each test. I decided to use "@Before"
   * and some field in the test Class to avoid repetition, 
   * I changed previous test as well. Change made after test5.
   * 
   * @author Gilberto Pestana
   */
  @Before
  public void before() {
    testedF = new Entry(5f);
    testedS = new Entry(Symbol.PLUS);
    testedSt = new Entry("some text to test");
    rd  = new Random();
    testedFR = new Entry(rd.nextFloat() * 100); //random Entry between [0-100)
    allSymbols = Symbol.values(); // Array with all possible Symbol Values
    testedSR = new Entry(allSymbols[rd.nextInt(allSymbols.length)]); //selects a random Symbol
  }
  
  /**
   * Test 0:  Test if the object Entry exists.
   * <p>To pass: I created the class Entry.</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testCreateEntry() {
    Entry tested;
  }
  
  /**
   * Test 1:  Test if the object Entry for floats exists.
   * <p>To pass: I added a constructor with a float as parameter.</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testFloatEntry() {
    Entry tested = new Entry(5f);
  }
  
  /**
   * Test 2:  Test if the object Entry for Symbols exists.
   * <p>To pass: I added a constructor with a Symbol as parameter.</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testSymbolEntry() {
    Entry tested = new Entry(Symbol.PLUS);
  }
  
  /**
   * Test 3:  Test if the object Entry for String exists.
   * <p>To pass: I added a constructor with a String as parameter.</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testStringEntry() {
    Entry tested = new Entry("Some text to test");
  }
  
  /**
   * Test 4:  Test the value of Entry(float).
   * <p>To pass: I added a method getValue() and made it return 5.0f.</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testGetValue() {
    try {
      assertEquals("error value not expected",5f,testedF.getValue(),0.001f);
    } catch (BadTypeException e) {
      assertTrue("this exception shouldn't rise because Entry type is NUMBER", false);
      e.printStackTrace();
    }
  }
  
  /**
   * Test 5:  Test if the value of two different Entry(float) are different.
   * <p>To pass: I had to create a field "number" to store the float given
   *          then I edited the Entry(float)'s constructor to store the parameter passed
   *          in the field "number". Finally I made getValue() return "this.number".</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testCompareGetValue() {
    Entry differentEntry = new Entry(6f);
    try {
      assertNotEquals("error different Entry(f)s have same value",
                      testedF.getValue(), differentEntry.getValue());
    } catch (BadTypeException e) {
      assertTrue("this exception shouldn't rise because Entry type is NUMBER", false);
      e.printStackTrace();
    }
  }
  
  /**
   * Test 6:  Test the value of Entry(Symbol).
   * <p>To pass: I added a method getSymbol() and made it return Symbol.PLUS.</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testGetSymbol() {
    try {
      assertEquals("error value not expected", Symbol.PLUS, testedS.getSymbol());
    } catch (BadTypeException e) {
      assertTrue("this exception shouldn't rise because Entry type is SYMBOL", false);
      e.printStackTrace();
    }
  }
  
  /**
   * Test 7:  Test if the Symbol of two different Entry(Symbol) are different.
   * <p>To pass: I had to create a field "symbol" to store the Symbol given
   *          then I edited the Entry(Symbol)'s constructor to store the parameter passed
   *          in the field "symbol". Finally I made getSymbol() return "this.symbol".</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testCompareGetSymbol() {
    Entry differentSymbol = new Entry(Symbol.MINUS);
    try {
      assertNotEquals("error different Entry(Symbol)s have same Symbol",
                      testedS.getSymbol(), differentSymbol.getSymbol());
    } catch (BadTypeException e) {
      assertTrue("this exception shouldn't rise because Entry type is SYMBOL", false);
      e.printStackTrace();
    }
  }
  
  /**
   * Test 8:  Test the value of Entry(String).
   * <p>To pass: I added a method getString() and made it return "some text to test".</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testGetString() {
    try {
      assertEquals("error string not expected", "some text to test", testedSt.getString());
    } catch (BadTypeException e) {
      assertTrue("this exception shouldn't rise because Entry type is STRING", false);
      e.printStackTrace();
    }
  }
  
  /**
   * Test 9:  Test if the String stored in two different Entry(String) are different.
   * <p>To pass: I had to create a field "str" to store the String given as parameter
   *          then I edited the Entry(String)'s constructor to store the parameter passed
   *          in the field "str". Finally I made getString() return "this.str".</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testCompareGetString() {
    Entry differentTested = new Entry("some other text");
    try {
      assertNotEquals("error different Entry(String)s have same String",
                      testedSt.getString(), differentTested.getString());
    } catch (BadTypeException e) {
      assertTrue("this exception shouldn't rise because Entry type is STRING", false);
      e.printStackTrace();
    }
  }
  
  /**
   * Test 10: Test if two objects Entry() with same information (String and Type) are equals.
   * <p>To pass: I had to override equals and hasCode methods. I got some help from eclipse.</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testEquals() {
    Entry[] original = {testedF,testedS,testedSt};
    Entry[] clon = {new Entry(5f),new Entry(Symbol.PLUS),new Entry("some text to test")};
    for (int i = 0; i < original.length; i++) {
      assertEquals("error: equal Entry are treat as different objects",
                   original[i],clon[i]);
    }
  }
  
  /**
   * Test 11: Test if two different objects Entry() with different information are different.
   * <p>To pass: the problem was, objects like Entry(float) and Entry(Symbol) had the fields used
   *          by equals() and hasCode() set to null.
   *          I had to make each constructor set a Type and store the parameter passed as a String
   *          in the "str" field.</p>
   *    
   * @author Gilberto Pestana
   */
  @Test
  public void testEqualsOnDifferentEntry() {
    Entry[] entries = {testedFR,testedSR,testedSt};
    for (int i = 0; i < entries.length; i++) {
      for (int j = 0; j < entries.length; j++) {
        if (i != j) { //makes impossible to test 2 equal Entry()s. thus, fail the test 
          assertNotEquals("error: different Entry are treat as equals",
                           entries[i],entries[j]);
        }
      }
    }
  }
  
  /**
   * Test 12: confirm Entry(5.0f) and Entry("5.0") are different.
   * <p>to pass: equals proved to work perfectly. no change needed.</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testEqualsOnDifferentEntryTwo() {
    assertNotEquals("error Entry(5.0) and Entry(5.0f) are equals",testedF,new Entry("5.0"));
  }
  
  /**
   * Test 13: Test if an exception is thrown when calling getValue() from an Entry that
   *          is not supposed to i.e. Entry(String). 
   * <p>To pass: I made getSymbol throw a BadTypeException if the object from where
   *          the method is called is not Type.NUMBER.</p>
   * 
   * @author Gilberto Pestana
   * @throws BadTypeException rise when calling a invalid getter from Entry()
   */
  @Test
  public void testGetValueException() throws BadTypeException {
    thrown.expect(BadTypeException.class);
    thrown.expectMessage("getValue() can't be called from a Entry of type: " + testedSt.getType());
    testedSt.getValue(); //calling getValue from Entry(String)
  }
  
  /**
   * Test 14: Test if an exception is thrown when calling getString() from an Entry that
   *          is not supposed to i.e. Entry(Symbol). 
   * <p>To pass: I made getString throw a BadTypeException if the object from where
   *          the method is called is not Type.STRING.</p>
   * 
   * @author Gilberto Pestana
   * @throws BadTypeException rise when calling a invalid getter from Entry()
   */
  @Test
  public void testGetStringExceptions() throws BadTypeException {
    thrown.expect(BadTypeException.class);
    thrown.expectMessage("getString() can't be called from a Entry of type: " + testedS.getType());
    testedS.getString(); //calling getString from Entry(Symbol)
  }
  
  /**
   * Test 15: Test if an exception is thrown when calling getSymbol() from an Entry that
   *          is not supposed to i.e. Entry(float). 
   * <p>To pass: I made getSymbol throw a BadTypeException if the object from where
   *          the method is called is not Type.SYMBOL.</p>
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testGetSymbolExceptions() {
    boolean result = false;
    try {
      testedF.getSymbol(); //calling getSymbol from Entry(float)
    } catch (BadTypeException e) {
      result = true;
    }
    assertTrue(result);
  }

}
