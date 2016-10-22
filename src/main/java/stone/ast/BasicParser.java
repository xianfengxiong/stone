package stone.ast;

import stone.Lexer;
import stone.ParseException;
import stone.Parser;
import stone.Token;
import stone.Parser.Operators;
import static stone.Parser.rule;

import java.util.HashSet;

/**
 * @author xxf
 * @since 10/21/16
 */
public class BasicParser {
  HashSet<String> reserved = new HashSet<String>();
  Parser.Operators operators = new Parser.Operators();
  Parser expr0 = rule();
  Parser primary = rule(PrimaryExpr.class)
      .or(rule().seq("(").ast(expr0).seq(")"),
          rule().number(NumberLiteral.class),
          rule().identifier(Name.class,reserved),
          rule().string(StringLiteral.class));

  Parser factor = rule().or(rule(NegativeExpr.class).seq("-").ast(primary), primary);
  Parser expr = expr0.expression(BinaryExpr.class,factor,operators);

  Parser statement0 = rule();
  Parser block = rule(BlockStmnt.class)
      .seq("{").option(statement0)
      .repeat(rule().seq(";", Token.EOL).option(statement0))
      .seq("}");
  Parser simple = rule(PrimaryExpr.class).ast(expr);
  Parser statement = statement0.or(
      rule(IfStmnt.class).seq("if").ast(expr).ast(block)
                          .option(rule().seq("else").ast(block)),
      rule(WhileStmnt.class).seq("while").ast(expr).ast(block),
      simple
  );

  Parser program = rule().or(statement,rule(NullStmnt.class))
      .seq(";",Token.EOL);

  public BasicParser(){
    reserved.add(";");
    reserved.add("}");
    reserved.add(Token.EOL);

    operators.add("=",1,Operators.RIGHT);
    operators.add("==",2,Operators.LEFT);
    operators.add(">",2,Operators.LEFT);
    operators.add("<",2,Operators.LEFT);
    operators.add("+",3,Operators.LEFT);
    operators.add("-",3,Operators.LEFT);
    operators.add("*",4,Operators.LEFT);
    operators.add("/",4,Operators.LEFT);
    operators.add("%",4,Operators.LEFT);
  }
  public ASTree parse(Lexer lexer) throws ParseException {
    return program.parse(lexer);
  }
}
