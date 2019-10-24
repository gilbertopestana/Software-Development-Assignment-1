package calculator;

/**
 * Enum used to specified Type of an Entry.
 * 
 * @author Gilberto Pestana
 * @version 1.0, 10/20/2019
 * @see Entry
 * @since 1.0
 */
public enum Type {
  NUMBER("NUMBER"), 
  SYMBOL("SYMBOL"), 
  STRING("STRING"), 
  INVALID("INVALID");

  private String name;

  private Type(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name;
  }

}
