package calculator;

/**
 * The class <code>BadTypeException</code> is a form of <code>Throwable</code> that 
 * indicates conditions that a reasonable application might want to catch. 
 * 
 * @author Gilberto Pestana
 * @see    Exception
 */
public class BadTypeException extends Exception {

  private static final long serialVersionUID = 8103455150489603354L;

  /**
   * Throws an <code>Exception</code> of type <code>BadTypeException</code>.
   * 
   * @author       Gilberto Pestana
   * @param string the error message to be displayed.
   */
  public BadTypeException(String string) {
    super(string);
  }
}
