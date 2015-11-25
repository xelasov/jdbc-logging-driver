package org.xelasov.jdbc.logdriver;

import java.io.CharArrayReader;
import java.io.Reader;

import org.junit.Assert;
import org.junit.Test;

public class ParameterTest {
  private static final String regexOutParam = "^<[0-9]+:(IN|OUT):[a-zA-Z_]+>";
  private static final String regexInParam  = "^<[0-9]+:(IN|OUT):[a-zA-Z_]+:[0-9a-zA-Z@.]+>";

  @Test
  public void testMakeOutParam() {
    int index = 1;
    for (int sqlType : Parameter.sqlTypes.keySet()) {
      final Parameter p = Parameter.makeOutParam(index++, sqlType);
      check(regexOutParam, p);
    }
  }

  @Test
  public void testMakeInParam() {
    int index = 1;
    check(regexInParam, Parameter.makeInParam(index++, Byte.class, index));
    check(regexInParam, Parameter.makeInParam(index++, Short.class, index));
    check(regexInParam, Parameter.makeInParam(index++, Integer.class, index));
    check(regexInParam, Parameter.makeInParam(index++, Long.class, index));
    check(regexInParam, Parameter.makeInParam(index++, Float.class, index));
    check(regexInParam, Parameter.makeInParam(index++, Double.class, index));
    check(regexInParam, Parameter.makeInParam(index++, Reader.class, new CharArrayReader(new char[]{'0', '1', '2'})));

    //////////////
    check(regexInParam, Parameter.makeInParam(index++, new Long(index)));
  }


  private void check(final String regex, final Parameter p) {
    Assert.assertNotNull(p);
    final String s = p.toLogString();
    System.out.println("param = " + s);
    Assert.assertTrue(s != null && s.length() > 0);
    Assert.assertTrue(s, s.matches(regex));
  }

}