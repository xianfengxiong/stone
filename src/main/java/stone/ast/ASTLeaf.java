package stone.ast;

import stone.Token;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author xxf
 * @since 10/21/16
 */
public class ASTLeaf extends ASTree {
  private static ArrayList<ASTree> empty = new ArrayList<ASTree>();
  protected Token token;
  public ASTLeaf(Token t){token = t;}
  public ASTree child(int i) {throw new IndexOutOfBoundsException();}
  public int numChildren() {return 0;}
  public Iterator<ASTree> children() {return empty.iterator();}
  public String toString(){return token.getText();}
  public String location() {return "at line " + token.getLineNumber();}
  public Token token(){return token;}
}
