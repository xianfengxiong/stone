package chap6;

import stone.CodeDialog;
import stone.Lexer;
import stone.ParseException;
import stone.Token;
import stone.ast.ASTree;
import stone.ast.BasicParser;
import stone.ast.NullStmnt;

/**
 * @author xxf
 * @since 10/22/16
 */
public class BasicInterpreter {
  public static void main(String[] args) throws ParseException {
    run(new BasicParser(),new BasicEnv());
  }
  public static void run(BasicParser bp,Environment env) throws ParseException {
    Lexer lexer = new Lexer(new CodeDialog());
    while (lexer.peek(0) != Token.EOF){
      ASTree t = bp.parse(lexer);
      if (!(t instanceof NullStmnt)){
        Object r = ((BasicEvaluator.ASTreeEx)t).eval(env);
        System.out.println("=> " + r);
      }
    }
  }
}
