package stone.ast;

import java.util.Iterator;

/**
 * @author xxf
 * @since 10/21/16
 */
public abstract class ASTree implements Iterable<ASTree> {
  public abstract ASTree child(int i);
  public abstract int numChildren();
  public abstract Iterator<ASTree> children();
  public abstract String location();
  public Iterator<ASTree> iterator() {return children();}
}
