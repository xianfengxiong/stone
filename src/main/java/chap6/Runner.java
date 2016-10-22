package chap6;

import javassist.gluonj.util.Loader;

/**
 * @author xxf
 * @since 10/22/16
 */
public class Runner {
  public static void main(String[] args) throws Throwable {
    Loader.run(BasicInterpreter.class,args,BasicEvaluator.class);
  }
}
