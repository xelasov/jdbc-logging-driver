package org.xelasov.jdbc.logdriver;


import java.sql.Connection;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class LoggingStatementTest {

  @Test
  public void testBuildLogString() {
    final String            dbId     = "dbhost:4321/dbschema";
    final String            sql      = "select * from dual";
    final String            expected = "millis=0 db=[dbhost:4321/dbschema] q=[select * from dual]";
    final LoggingConnection conn     = new LoggingConnection(Mockito.mock(Connection.class), dbId);
    final long              millis   = 0;
    final String            actual   = LoggingStatement.buildLogString(sql, conn, millis);

    Assert.assertEquals(expected, actual);
  }
}