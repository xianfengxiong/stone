package stone.ast;

import stone.Token;

/**
 * @author xxf
 * @since 10/22/16
 */
public class StringLiteral extends ASTLeaf {
  public StringLiteral(Token t) {super(t);}
  public String value(){return token().getText();}
}
