package stone;

/**
 * @author xxf
 * @since 10/20/16
 */
public class StoneException extends RuntimeException {
  public StoneException(String m){super(m);}
//  public StoneException(String m,ASTree t){
//    super(m + " " + t.location());
//  }
}
