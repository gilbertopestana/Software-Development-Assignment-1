package testcalculator;

import static org.junit.Assert.assertEquals;

import calculator.Symbol;
import org.junit.Test;

/**
 * Class used to test and develop the Symbol class using TDD.
 * 
 * @author Gilberto Pestana
 * @see Symbol
 */
public class TestSymbol {

  /**
   * Test 1: Test if enum Symbols exists.
   * To pass: I created the enum Symbol class.
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testSymbol() {
    Symbol mySymbol;  
  }
  
  /**
   * Test 2: Test if toString() work correctly.
   * To pass: I created the method toString and made is pass the value/symbol/string stored.
   * 
   * @author Gilberto Pestana
   */
  @Test
  public void testToString() {
    assertEquals("error toString doesn't expected","-",Symbol.MINUS.toString());  
  }

}
