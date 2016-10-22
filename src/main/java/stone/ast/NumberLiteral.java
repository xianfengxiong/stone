package stone.ast;

import stone.Token;

/**
 * @author xxf
 * @since 10/21/16
 */
public class NumberLiteral extends ASTLeaf {
  public NumberLiteral(Token t) {super(t);}
  public int value(){return token().getNumber();}
}
