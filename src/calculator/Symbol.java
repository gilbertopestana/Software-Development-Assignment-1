package calculator;

/**
 * Enum used to specified a Symbol to be store on an Entry of type Symbol.
 * @author Gilberto Pestana
 * @version 1.0, 10/20/2019
 * @see Entry
 * @see Type
 * @since 1.0
 */
public enum Symbol { 
  LEFT_BRACKET('('),
  RIGHT_BRACKET(')'),
  TIMES('*'),
  DIVIDE('/'),
  PLUS('+'),
  MINUS('-'),
  INVALID('?');

  private char value;

  Symbol(char takenValue) {
    this.value = takenValue;
  }

  @Override
  public String toString() {
    return String.valueOf(this.value);
  }

}
