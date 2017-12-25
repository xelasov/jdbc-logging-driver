package org.xelasov.jdbc.logdriver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.xelasov.util.Stopwatch;

import static org.xelasov.jdbc.logdriver.Constants.MDC_JDBC_LATENCY;
import static org.xelasov.jdbc.logdriver.Constants.MDC_JDBC_SQL_KEY;
import static org.xelasov.jdbc.logdriver.Constants.MDC_JDBC_URL_KEY;
import static org.xelasov.jdbc.logdriver.DBCall.newJdbcCall;

public class LoggingStatement implements Statement {

  protected static final Logger log = LoggerFactory.getLogger("SQL.LOG");

  protected final LoggingConnection conn;
  private final Statement stmt;

  public LoggingStatement(final LoggingConnection conn, final Statement stmt) {
    this.stmt = stmt;
    this.conn = conn;
  }

  protected void log(DBCall call, Throwable e) {
    call.getTimer().stop();
    populateMDC(call);
    log.info(buildLogString(call.getSql(), conn, call.getTimer().elapsedMillis()), e);
  }

  protected void log(DBCall call) {
    call.getTimer().stop();
    populateMDC(call);
    log.info(buildLogString(call.getSql(), conn, call.getTimer().elapsedMillis()));
  }

  protected static String buildLogString(final String sql, LoggingConnection conn, final long millis) {
    return "millis=" + millis + " db=[" + conn.getDbId() + "] q=[" + sql + "]";
  }


  @Override
  public void addBatch(final String sql) throws SQLException {
    stmt.addBatch(sql);
  }

  @Override
  public void cancel() throws SQLException {
    stmt.cancel();
  }

  @Override
  public void clearBatch() throws SQLException {
    stmt.clearBatch();
  }

  @Override
  public void clearWarnings() throws SQLException {
    stmt.clearWarnings();
  }

  @Override
  public void close() throws SQLException {
    stmt.close();
  }

  @Override
  public boolean execute(final String sql) throws SQLException {
    DBCall call = newJdbcCall(sql);
    try {
      final boolean rv = stmt.execute(sql);
      log(call);
      return rv;
    } catch (SQLException | RuntimeException e) {
      log(call, e);
      throw e;
    }
  }

  @Override
  public boolean execute(final String sql, final int autoGeneratedKeys) throws SQLException {
    DBCall dbCall = newJdbcCall(sql);
    try {
      final boolean rv = stmt.execute(sql, autoGeneratedKeys);
      log(dbCall);
      return rv;
    } catch (SQLException | RuntimeException e) {
      log(dbCall, e);
      throw e;
    }
  }

  @Override
  public boolean execute(final String sql, final int[] columnIndexes) throws SQLException {
    DBCall dbCall = newJdbcCall(sql);
    try {
      final boolean rv = stmt.execute(sql, columnIndexes);
      log(dbCall);
      return rv;
    } catch (SQLException | RuntimeException e) {
      log(dbCall, e);
      throw e;
    }
  }

  @Override
  public boolean execute(final String sql, final String[] columnNames) throws SQLException {
    DBCall dbCall = newJdbcCall(sql);
    try {
      final boolean rv = stmt.execute(sql, columnNames);
      log(dbCall);
      return rv;
    } catch (SQLException | RuntimeException e) {
      log(dbCall, e);
      throw e;
    }
  }

  @Override
  public int[] executeBatch() throws SQLException {
    final String sql = "executeBatch";
    DBCall dbCall = newJdbcCall(sql);
    try {
      final int rv[] = stmt.executeBatch();
      log(dbCall);
      return rv;
    } catch (SQLException | RuntimeException e) {
      log(dbCall, e);
      throw e;
    }
  }

  @Override
  public ResultSet executeQuery(final String sql) throws SQLException {
    DBCall call = newJdbcCall(sql);

    try {
      final ResultSet rv = stmt.executeQuery(sql);
      log(call);
      return rv;
    } catch (SQLException | RuntimeException e) {
      log(call, e);
      throw e;
    }
  }

  @Override
  public int executeUpdate(final String sql) throws SQLException {
    DBCall call = newJdbcCall(sql);
    try {
      final int rv = stmt.executeUpdate(sql);
      log(call);
      return rv;
    } catch (SQLException | RuntimeException e) {
      log(call, e);
      throw e;
    }
  }

  @Override
  public int executeUpdate(final String sql, final int autoGeneratedKeys) throws SQLException {
    DBCall call = newJdbcCall(sql);
    try {
      final int rv = stmt.executeUpdate(sql, autoGeneratedKeys);
      log(call);
      return rv;
    } catch (SQLException | RuntimeException e) {
      log(call, e);
      throw e;
    }
  }

  @Override
  public int executeUpdate(final String sql, final int[] columnIndexes) throws SQLException {
    DBCall call = newJdbcCall(sql);
    try {
      final int rv = stmt.executeUpdate(sql, columnIndexes);
      log(call);
      return rv;
    } catch (SQLException | RuntimeException e) {
      log(call, e);
      throw e;
    }
  }

  @Override
  public int executeUpdate(final String sql, final String[] columnNames) throws SQLException {
    DBCall call = newJdbcCall(sql);
    try {
      final int rv = stmt.executeUpdate(sql, columnNames);
      log(call);
      return rv;
    } catch (SQLException | RuntimeException e) {
      log(call, e);
      throw e;
    }
  }

  @Override
  public Connection getConnection() throws SQLException {
    return conn;
  }

  @Override
  public int getFetchDirection() throws SQLException {
    return stmt.getFetchDirection();
  }

  @Override
  public void setFetchDirection(final int direction) throws SQLException {
    stmt.setFetchDirection(direction);
  }

  @Override
  public int getFetchSize() throws SQLException {
    return stmt.getFetchSize();
  }

  @Override
  public void setFetchSize(final int rows) throws SQLException {
    stmt.setFetchSize(rows);
  }

  @Override
  public ResultSet getGeneratedKeys() throws SQLException {
    return stmt.getGeneratedKeys();
  }

  @Override
  public int getMaxFieldSize() throws SQLException {
    return stmt.getMaxFieldSize();
  }

  @Override
  public void setMaxFieldSize(final int max) throws SQLException {
    stmt.setMaxFieldSize(max);
  }

  @Override
  public int getMaxRows() throws SQLException {
    return stmt.getMaxRows();
  }

  @Override
  public void setMaxRows(final int max) throws SQLException {
    stmt.setMaxRows(max);
  }

  @Override
  public boolean getMoreResults() throws SQLException {
    return stmt.getMoreResults();
  }

  @Override
  public boolean getMoreResults(final int current) throws SQLException {
    return stmt.getMoreResults(current);
  }

  @Override
  public int getQueryTimeout() throws SQLException {
    return stmt.getQueryTimeout();
  }

  @Override
  public void setQueryTimeout(final int seconds) throws SQLException {
    stmt.setQueryTimeout(seconds);
  }

  @Override
  public ResultSet getResultSet() throws SQLException {
    return stmt.getResultSet();
  }

  @Override
  public int getResultSetConcurrency() throws SQLException {
    return stmt.getResultSetConcurrency();
  }

  @Override
  public int getResultSetHoldability() throws SQLException {
    return stmt.getResultSetHoldability();
  }

  @Override
  public int getResultSetType() throws SQLException {
    return stmt.getResultSetType();
  }

  @Override
  public int getUpdateCount() throws SQLException {
    return stmt.getUpdateCount();
  }

  @Override
  public SQLWarning getWarnings() throws SQLException {
    return stmt.getWarnings();
  }

  @Override
  public boolean isClosed() throws SQLException {
    return stmt.isClosed();
  }

  @Override
  public boolean isPoolable() throws SQLException {
    return stmt.isPoolable();
  }

  @Override
  public void setPoolable(final boolean poolable) throws SQLException {
    stmt.setPoolable(poolable);
  }

  @Override
  public boolean isWrapperFor(final Class<?> iface) throws SQLException {
    return stmt.isWrapperFor(iface);
  }

  @Override
  public void setCursorName(final String name) throws SQLException {
    stmt.setCursorName(name);
  }

  @Override
  public void setEscapeProcessing(final boolean enable) throws SQLException {
    stmt.setEscapeProcessing(enable);
  }

  @Override
  public <T> T unwrap(final Class<T> iface) throws SQLException {
    return stmt.unwrap(iface);
  }

  @Override
  public void closeOnCompletion() throws SQLException {
    stmt.closeOnCompletion();
  }

  @Override
  public boolean isCloseOnCompletion() throws SQLException {
    return stmt.isCloseOnCompletion();
  }

  protected void populateMDC(DBCall call) {
    MDC.put(MDC_JDBC_URL_KEY, conn.getDbId());
    MDC.put(MDC_JDBC_SQL_KEY, call.getSql());
    MDC.put(MDC_JDBC_LATENCY, String.valueOf(call.getTimer().elapsedMillis()));
  }

}
