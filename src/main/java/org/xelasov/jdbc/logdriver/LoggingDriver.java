package org.xelasov.jdbc.logdriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class LoggingDriver implements Driver {

  private static final String urlPrefix = "jdbc:logging:";

  static {
    try {
      DriverManager.registerDriver(new LoggingDriver());
    } catch (final SQLException e) {
      throw new RuntimeException("Can't register DB bench driver: " + e.getMessage(), e);
    }
  }

  protected static String computeDBId(String delegateUrl) {
    return delegateUrl.replaceFirst("^.*//", "").replaceFirst("\\?.*", "");
  }

  protected static String computeDelegateUrl(String url) {
    return url.replaceFirst(urlPrefix, "jdbc:");
  }

  protected static boolean canAcceptUrl(String url) {
    return url.startsWith(urlPrefix);
  }

  @Override
  public Connection connect(String url, Properties info) throws SQLException {
    if (!acceptsURL(url))
      return null;

    final String     delegateUrl  = computeDelegateUrl(url);
    final String     dbId         = computeDBId(delegateUrl);
    final Connection delegateConn = DriverManager.getConnection(delegateUrl, info);
    if (delegateConn == null)
      throw new SQLException("Unable to acquire a JDBC connection with the URL '" + delegateUrl + "'");
    return new LoggingConnection(delegateConn, dbId);
  }

  @Override
  public boolean acceptsURL(String url) throws SQLException {
    return canAcceptUrl(url);
  }

  @Override
  public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
    if (acceptsURL(url))
      return new DriverPropertyInfo[0];
    else
      return null;
  }

  @Override
  public int getMajorVersion() {
    return 1;
  }

  @Override
  public int getMinorVersion() {
    return 2;
  }

  @Override
  public boolean jdbcCompliant() {
    return false;
  }

  @Override
  public Logger getParentLogger() throws SQLFeatureNotSupportedException {
    throw new SQLFeatureNotSupportedException();
  }
}
