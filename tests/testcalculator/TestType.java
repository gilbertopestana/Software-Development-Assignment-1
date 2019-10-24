package testcalculator;

import static org.junit.Assert.assertEquals;

import calculator.Symbol;
import calculator.Type;
import org.junit.Test;

/**
 * Class used to test and develop the Type class using TDD.
 * 
 * @author Gilberto Pestana
 * @see Type
 */
public class TestType {

  /**
   * Test 1: Test if enum Type exists.
   * To pass: I created the enum Type class
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void test() {
    Type myType;
  }
  
  /**
   * Test 2: Test if toString() work correctly.
   * To pass: I created the method toString and made is pass the Type stored.
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testToString() {
    assertEquals("error toString doesn't expected","NUMBER",Type.NUMBER.toString());  
  }
}
