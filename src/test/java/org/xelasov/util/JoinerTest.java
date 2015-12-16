package org.xelasov.util;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

public class JoinerTest {
  final static String dlm    = ",";
  final static String prefix = "<";
  final static String suffix = ">";

  @Test
  public void testFieldsToString() {

    Assert.assertEquals("<>", Joiner.fieldsToString(prefix, Collections.EMPTY_LIST, dlm, suffix));
    Assert.assertEquals("<a>", Joiner.fieldsToString(prefix, Arrays.asList("a"), dlm, suffix));
    Assert.assertEquals("<a,b>", Joiner.fieldsToString(prefix, Arrays.asList("a", "b"), dlm, suffix));
    Assert.assertEquals("<a,b,c>", Joiner.fieldsToString(prefix, Arrays.asList("a", "b", "c"), dlm, suffix));
  }

  @Test
  public void testConstructor() {

    Assert.assertEquals("<>", new Joiner(dlm, prefix, suffix).join(null));
    Assert.assertEquals(">", new Joiner(dlm, null, suffix).join(null));
    Assert.assertEquals("<", new Joiner(dlm, prefix, null).join(null));
    Assert.assertEquals("", new Joiner(dlm, null, null).join(null));
    Assert.assertEquals("<a>", new Joiner(dlm, prefix, suffix).join("a"));
    Assert.assertEquals("<a,b>", new Joiner(dlm, prefix, suffix).join("a", "b"));
    Assert.assertEquals("<a,b,c>", new Joiner(dlm, prefix, suffix).join("a", "b", "c"));

  }
}