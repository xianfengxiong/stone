package stone;

/**
 * 标识符，整形字面量，字符串字面量
 * @author xxf
 * @since 10/20/16
 */
public abstract class Token {
  public static final Token EOF = new Token(-1){};
  public static final String EOL = "\\n";
  private int lineNumber;

  protected Token(int line){
    lineNumber = line;
  }

  public int getLineNumber(){return lineNumber;}
  public boolean isIdentifier(){return false;}
  public boolean isNumber(){return false;}
  public boolean isString(){return false;}
  public int getNumber(){throw new StoneException("not number token");}
  public String getText(){return "";}

}
