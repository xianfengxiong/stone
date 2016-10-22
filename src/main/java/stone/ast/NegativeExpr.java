package stone.ast;

import java.util.List;

/**
 * @author xxf
 * @since 10/21/16
 */
public class NegativeExpr extends ASTList {
  public NegativeExpr(List<ASTree> c) {super(c);}
  public ASTree operand(){return child(0);}
  public String toString(){
    return "-" + operand();
  }
}
