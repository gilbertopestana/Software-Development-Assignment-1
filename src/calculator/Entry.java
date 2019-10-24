package calculator;

/**
 * This class creates objects of type number, symbol or string of which can be used to store
 * information as floats i.e "5.0", operation symbols i.e. "+" and string i.e. "5 + 4 - 2".
 * 
 * @author  Gilberto Pestana
 * @see     Type
 * @see     Symbol
 * @version 1.0, 10/20/2019
 * @since   1.0
 */
public class Entry {
  private float number;
  private Symbol symbol;
  private String str;
  private Type type;

  /**
   * Creates an Entry of type <code>Type.NUMBER</code> and stores the argument passed.
   * 
   * @author            Gilberto Pestana
   * @param numberGiven float to be stored.
   * @see               Type
   * @since             1.0
   */
  public Entry(float numberGiven) {
    this.number = numberGiven;
    this.symbol = null;
    this.type = Type.NUMBER;
    this.str = Float.toString(numberGiven);
  }

  /**
   * Creates an Entry of type <code>Type.SYMBOL</code> and stores the argument passed.
   * 
   * @author            Gilberto Pestana
   * @param symbolGiven Symbol to be stored.
   * @see               Type
   * @see               Symbol
   * @since             1.0
   */
  public Entry(Symbol symbolGiven) {
    this.symbol = symbolGiven;
    this.number = 0.0f;
    this.type = Type.SYMBOL;
    this.str = symbolGiven.toString();
  }

  /**
   * Creates an Entry of type <code>Type.STRING</code> and stores the argument passed.
   * 
   * @author       Gilberto Pestana
   * @param string String to be stored.
   * @see          Type
   * @since        1.0
   */
  public Entry(String string) {
    this.str = string;
    this.symbol = null;
    this.number = 0.0f;
    this.type = Type.STRING;
  }

  /**
   * Returns the value stored in an Entry of <code>Type.NUMBER</code>.
   * If type is different throws an exception.
   * 
   * @author                  Gilberto Pestana
   * @return                  Float representing the value stored.
   * @throws BadTypeException When called from Entry of type different than Type.NUMBER
   * @see                     Type
   * @since                   1.0
   */
  public float getValue() throws BadTypeException {
    if (this.type != Type.NUMBER) {
      throw new BadTypeException("getValue() can't be called from a Entry of type: " 
                                   + this.type.toString());
    }
    return this.number;
  }

  /**
   * Returns the symbol stored in an Entry of <code>Type.NUMBER</code>.
   * If type is different throws an exception.
   * 
   * @author                  Gilberto Pestana
   * @return                  Symbol representing the symbol stored.
   * @throws BadTypeException When called from Entry of type different than Type.SYMBOL
   * @see                     Type
   * @since                   1.0
   */
  public Symbol getSymbol() throws BadTypeException {
    if (this.type != Type.SYMBOL) {
      throw new BadTypeException("getSymbol() can't be called from a Entry of type: " 
                                   + this.type.toString());
    }
    return this.symbol;
  }
  
  /**
   * Returns the string store in an Entry of <code>Type.STRING</code>.
   * If type is different throws an exception.
   * 
   * @author                  Gilberto Pestana
   * @return                  String representing the value stored.
   * @throws BadTypeException When called from Entry of type different than Type.STRING
   * @see                     Type
   * @since                   1.0
   */
  public String getString() throws BadTypeException {
    if (this.type != Type.STRING) {
      throw new BadTypeException("getString() can't be called from a Entry of type: " 
                                   + this.type.toString());
    }
    return this.str;
  }
  
  /**
   * Returns the Type of an Entry <code>Type.NUMBER</code>.
   * 
   * @author Gilberto Pestana
   * @return Type representing the Entry Type.
   * @since  1.0
   */
  public Type getType() {
    return this.type;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((str == null) ? 0 : str.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Entry other = (Entry) obj;
    if (str == null) {
      if (other.str != null) {
        return false;
      }
    } else if (!str.equals(other.str)) {
      return false;
    }
    if (type != other.type) {
      return false;
    }
    return true;
  }

  
  
}
