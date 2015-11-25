package org.xelasov.jdbc.logdriver;

import java.io.CharArrayReader;
import java.io.Reader;

import org.junit.Assert;
import org.junit.Test;

public class ParameterTest {

  @Test
  public void testMakeOutParam() {
    int index = 1;
    for (int sqlType : Parameter.sqlTypes.keySet()) {
      final Parameter p = Parameter.makeOutParam(index++, sqlType);
      check(p);
    }
  }

  @Test
  public void testMakeInParam() {
    int index = 1;
    check(Parameter.makeInParam(index++, Byte.class, index));
    check(Parameter.makeInParam(index++, Short.class, index));
    check(Parameter.makeInParam(index++, Integer.class, index));
    check(Parameter.makeInParam(index++, Long.class, index));
    check(Parameter.makeInParam(index++, Float.class, index));
    check(Parameter.makeInParam(index++, Double.class, index));
    check(Parameter.makeInParam(index++, Reader.class, new CharArrayReader(new char[]{'0', '1', '2'})));

    //////////////
    check(Parameter.makeInParam(index++, new Long(index)));
  }

  private void check(final Parameter p) {
    Assert.assertNotNull(p);
    final String s = p.toLogString();
    Assert.assertTrue(s != null && s.length() > 0);
    System.out.println("param = " + s);
  }

}