package chap6;

import java.util.HashMap;

/**
 * @author xxf
 * @since 10/22/16
 */
public class BasicEnv implements Environment {
  protected HashMap<String,Object> values;
  public BasicEnv(){values = new HashMap<>();}
  public void put(String name, Object value) {values.put(name,value);}
  public Object get(String name) {return values.get(name);}
}
