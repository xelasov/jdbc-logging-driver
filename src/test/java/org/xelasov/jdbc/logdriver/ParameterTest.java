package org.xelasov.jdbc.logdriver;

import java.io.CharArrayReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ParameterTest {
  private static final String regexOutParam = "^<[0-9]+:(IN|OUT):[a-zA-Z_]+>";
  private static final String regexInParam  = "^<[0-9]+:(IN|OUT):[a-zA-Z_]+:[0-9a-zA-Z@.]+>";

  @Test
  public void testMakeOutParam() {
    final List<Parameter> outParams = makeOutParams();
    for (Parameter p : outParams)
      check(regexOutParam, p);
  }

  @Test
  public void testMakeInParam() {
    for (Parameter p : makeInParams()) {
      check(regexInParam, p);
    }
  }

  @Test
  public void testToLogString() {
    final String regexStr    = "^\\[<1:IN:Byte:2>,<2:IN:Short:3>,<3:IN:Integer:4>,<4:IN:Long:5>,<5:IN:Float:6>,<6:IN:Double:7>,<7:IN:Reader:java.io.CharArrayReader@[0-9a-z]+>,<8:IN:Long:9>\\]$";
    final String actualInStr = Parameter.toLogString(makeInParams());//.replace('[', '=').replace(']', '=');
    Assert.assertTrue(actualInStr != null && !actualInStr.isEmpty());
    Assert.assertTrue("|" + actualInStr + "|", actualInStr.matches(regexStr));
  }

  @Test
  public void testToOutLogString() {
    final String expectedOutStr = "[<1:OUT:LONGVARCHAR>,<2:OUT:NULL>,<3:OUT:CHAR>,<4:OUT:BINARY>,<5:OUT:NUMERIC>,<6:OUT:VARBINARY>,<7:OUT:DECIMAL>,<8:OUT:LONGVARBINARY>,<9:OUT:INTEGER>,<10:OUT:BIGINT>,<11:OUT:TINYINT>,<12:OUT:SMALLINT>,<13:OUT:BIT>,<14:OUT:FLOAT>,<15:OUT:DATALINK>,<16:OUT:REAL>,<17:OUT:ROWID>,<18:OUT:DOUBLE>,<19:OUT:NVARCHAR>,<20:OUT:VARCHAR>,<21:OUT:NCHAR>,<22:OUT:LONGNVARCHAR>,<23:OUT:JAVA_OBJECT>,<24:OUT:BOOLEAN>,<25:OUT:DISTINCT>,<26:OUT:STRUCT>,<27:OUT:ARRAY>,<28:OUT:BLOB>,<29:OUT:CLOB>,<30:OUT:REF>,<31:OUT:OTHER>,<32:OUT:SQLXML>,<33:OUT:DATE>,<34:OUT:NCLOB>,<35:OUT:TIME>,<36:OUT:REF_CURSOR>,<37:OUT:TIMESTAMP>,<38:OUT:TIME_WITH_TIMEZONE>,<39:OUT:TIMESTAMP_WITH_TIMEZONE>]";
    Assert.assertEquals(expectedOutStr, Parameter.toLogString(makeOutParams()));
  }


  @Test
  public void testToEmptyLogString() {
    Assert.assertEquals("[]", Parameter.toLogString(Collections.emptyList()));
  }


  private void check(final String regex, final Parameter p) {
    Assert.assertNotNull(p);
    final String s = p.toLogString();
    System.out.println("param = " + s);
    Assert.assertTrue(s != null && s.length() > 0);
    Assert.assertTrue(s, s.matches(regex));
  }

  private static List<Parameter> makeOutParams() {
    final ArrayList<Parameter> rv    = new ArrayList<>();
    int                        index = 1;
    for (int sqlType : Parameter.sqlTypes.keySet()) {
      final Parameter p = Parameter.makeOutParam(index++, sqlType);
      rv.add(p);
    }
    return rv;
  }

  private static List<Parameter> makeInParams() {
    final ArrayList<Parameter> rv    = new ArrayList<>();
    int                        index = 1;
    rv.add(Parameter.makeInParam(index++, Byte.class, index));
    rv.add(Parameter.makeInParam(index++, Short.class, index));
    rv.add(Parameter.makeInParam(index++, Integer.class, index));
    rv.add(Parameter.makeInParam(index++, Long.class, index));
    rv.add(Parameter.makeInParam(index++, Float.class, index));
    rv.add(Parameter.makeInParam(index++, Double.class, index));
    rv.add(Parameter.makeInParam(index++, Reader.class, new CharArrayReader(new char[]{'0', '1', '2'})));
    rv.add(Parameter.makeInParam(index++, new Long(index)));
    return rv;
  }
}