package org.xelasov.jdbc.logdriver;


import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

public class LoggingDriverTest {

  @Test
  public void testComputeDBId() {
    Assert.assertEquals("pg-dev:5432/pgdev", LoggingDriver.computeDBId("jdbc:postgresql://pg-dev:5432/pgdev"));
    Assert.assertEquals("pg-dev:5432/pgdev", LoggingDriver.computeDBId("jdbc:postgresql://pg-dev:5432/pgdev?k1=v1&k2=v2"));
    Assert.assertEquals("pg-dev:5432/pgdev", LoggingDriver.computeDBId("jdbc:logging:postgresql://pg-dev:5432/pgdev"));
  }

  @Test
  public void testComputeDelegateUrl() {
    Assert.assertEquals("jdbc:postgresql://pg-dev:5432/pgdev", LoggingDriver.computeDelegateUrl("jdbc:postgresql://pg-dev:5432/pgdev"));
    Assert.assertEquals("jdbc:postgresql://pg-dev:5432/pgdev", LoggingDriver.computeDelegateUrl("jdbc:logging:postgresql://pg-dev:5432/pgdev"));

  }

  @Test
  public void testCanAcceptsURL() {
    Assert.assertFalse(LoggingDriver.canAcceptUrl("jdbc:postgresql://pg-dev:5432/pgdev"));
    Assert.assertTrue(LoggingDriver.canAcceptUrl("jdbc:logging:postgresql://pg-dev:5432/pgdev"));
    Assert.assertTrue(LoggingDriver.canAcceptUrl("jdbc:logging:postgresql://pg-dev:5432/pgdev/blah/blah/blah?k1=v1&k2=v2"));
  }

  @Test
  public void testDriverManagerIntegration() throws SQLException {
    final Driver actualDriver = DriverManager.getDriver("jdbc:logging:postgresql://pg-dev:5432/pgdev");
    Assert.assertEquals(LoggingDriver.class, actualDriver.getClass());

    LoggingDriver ld = (LoggingDriver) actualDriver;
  }

}
