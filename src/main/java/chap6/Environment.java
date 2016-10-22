package chap6;

/**
 * @author xxf
 * @since 10/22/16
 */
public interface Environment {
  void put(String name, Object value);
  Object get(String name);
}
