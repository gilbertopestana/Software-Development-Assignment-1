package calculator;

/**
 * The class <code>EmptyStackException</code> is a form of <code>Throwable</code> that 
 * indicates conditions that a reasonable application might want to catch. 
 * 
 * @author Gilberto Pestana
 * @see    Exception
 */
public class EmptyStackException extends Exception {

  private static final long serialVersionUID = -1743343566172860617L;

  /**
   * Throws an <code>exception</code> of type <code>EmptyStackException</code>.
   * 
   * @author       Gilberto Pestana
   * @param string the error message to be displayed.
   */
  public EmptyStackException(String string) {
    super(string);
  }
}
