package org.xelasov.jdbc.logdriver;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import com.google.common.base.Strings;

import static com.google.common.base.Preconditions.checkArgument;

public class LoggingConnection implements Connection {

  private final Connection conn;
  private final String     dbId;

  public LoggingConnection(final Connection conn, final String dbId) {
    checkArgument(conn != null);
    checkArgument(!Strings.isNullOrEmpty(dbId));

    this.dbId = dbId;
    this.conn = conn;
  }

  public String getDbId() {
    return dbId;
  }

  @Override
  public void clearWarnings() throws SQLException {
    conn.clearWarnings();
  }

  @Override
  public void close() throws SQLException {
    conn.close();
  }

  @Override
  public void commit() throws SQLException {
    conn.commit();
  }

  @Override
  public Array createArrayOf(final String typeName, final Object[] elements) throws SQLException {
    return conn.createArrayOf(typeName, elements);
  }

  @Override
  public Blob createBlob() throws SQLException {
    return conn.createBlob();
  }

  @Override
  public Clob createClob() throws SQLException {
    return conn.createClob();
  }

  @Override
  public NClob createNClob() throws SQLException {
    return conn.createNClob();
  }

  @Override
  public SQLXML createSQLXML() throws SQLException {
    return conn.createSQLXML();
  }

  @Override
  public Statement createStatement() throws SQLException {
    return new LoggingStatement(this, conn.createStatement());
  }

  @Override
  public Statement createStatement(final int resultSetType, final int resultSetConcurrency) throws SQLException {
    return new LoggingStatement(this, conn.createStatement(resultSetType, resultSetConcurrency));
  }

  @Override
  public Statement createStatement(final int resultSetType, final int resultSetConcurrency, final int resultSetHoldability) throws SQLException {
    return new LoggingStatement(this, conn.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability));
  }

  @Override
  public Struct createStruct(final String typeName, final Object[] attributes) throws SQLException {
    return conn.createStruct(typeName, attributes);
  }

  @Override
  public boolean getAutoCommit() throws SQLException {
    return conn.getAutoCommit();
  }

  @Override
  public void setAutoCommit(final boolean autoCommit) throws SQLException {
    conn.setAutoCommit(autoCommit);
  }

  @Override
  public String getCatalog() throws SQLException {
    return conn.getCatalog();
  }

  @Override
  public void setCatalog(final String catalog) throws SQLException {
    conn.setCatalog(catalog);
  }

  @Override
  public Properties getClientInfo() throws SQLException {
    return conn.getClientInfo();
  }

  @Override
  public void setClientInfo(final Properties properties) throws SQLClientInfoException {
    conn.setClientInfo(properties);
  }

  @Override
  public String getClientInfo(final String name) throws SQLException {
    return conn.getClientInfo(name);
  }

  @Override
  public int getHoldability() throws SQLException {
    return conn.getHoldability();
  }

  @Override
  public void setHoldability(final int holdability) throws SQLException {
    conn.setHoldability(holdability);
  }

  @Override
  public DatabaseMetaData getMetaData() throws SQLException {
    return conn.getMetaData();
  }

  @Override
  public int getTransactionIsolation() throws SQLException {
    return conn.getTransactionIsolation();
  }

  @Override
  public void setTransactionIsolation(final int level) throws SQLException {
    conn.setTransactionIsolation(level);
  }

  @Override
  public Map<String, Class<?>> getTypeMap() throws SQLException {
    return conn.getTypeMap();
  }

  @Override
  public void setTypeMap(final Map<String, Class<?>> map) throws SQLException {
    conn.setTypeMap(map);
  }

  @Override
  public SQLWarning getWarnings() throws SQLException {
    return conn.getWarnings();
  }

  @Override
  public boolean isClosed() throws SQLException {
    return conn.isClosed();
  }

  @Override
  public boolean isReadOnly() throws SQLException {
    return conn.isReadOnly();
  }

  @Override
  public void setReadOnly(final boolean readOnly) throws SQLException {
    conn.setReadOnly(readOnly);
  }

  @Override
  public boolean isValid(final int timeout) throws SQLException {
    return conn.isValid(timeout);
  }

  @Override
  public boolean isWrapperFor(final Class<?> iface) throws SQLException {
    if (iface.isAssignableFrom(getClass()))
      return true;
    else
      return conn.isWrapperFor(iface);
  }

  @Override
  public String nativeSQL(final String sql) throws SQLException {
    return conn.nativeSQL(sql);
  }

  @Override
  public CallableStatement prepareCall(final String sql) throws SQLException {
    return new LoggingCallableStatement(this, conn.prepareCall(sql), sql);
  }

  @Override
  public CallableStatement prepareCall(final String sql, final int resultSetType, final int resultSetConcurrency) throws SQLException {
    return new LoggingCallableStatement(this, conn.prepareCall(sql, resultSetType, resultSetConcurrency), sql);
  }

  @Override
  public CallableStatement prepareCall(final String sql, final int resultSetType, final int resultSetConcurrency, final int resultSetHoldability) throws SQLException {
    return new LoggingCallableStatement(this, conn.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability), sql);
  }

  @Override
  public PreparedStatement prepareStatement(final String sql) throws SQLException {
    return new LoggingPreparedStatement(this, conn.prepareStatement(sql), sql);
  }

  @Override
  public PreparedStatement prepareStatement(final String sql, final int autoGeneratedKeys) throws SQLException {
    return new LoggingPreparedStatement(this, conn.prepareStatement(sql, autoGeneratedKeys), sql);
  }

  @Override
  public PreparedStatement prepareStatement(final String sql, final int resultSetType, final int resultSetConcurrency) throws SQLException {
    return new LoggingPreparedStatement(this, conn.prepareStatement(sql, resultSetType, resultSetConcurrency), sql);
  }

  @Override
  public PreparedStatement prepareStatement(final String sql, final int resultSetType, final int resultSetConcurrency, final int resultSetHoldability) throws SQLException {
    return new LoggingPreparedStatement(this, conn.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability), sql);
  }

  @Override
  public PreparedStatement prepareStatement(final String sql, final int[] columnIndexes) throws SQLException {
    return new LoggingPreparedStatement(this, conn.prepareStatement(sql, columnIndexes), sql);
  }

  @Override
  public PreparedStatement prepareStatement(final String sql, final String[] columnNames) throws SQLException {
    return new LoggingPreparedStatement(this, conn.prepareStatement(sql, columnNames), sql);
  }

  @Override
  public void releaseSavepoint(final Savepoint savepoint) throws SQLException {
    conn.releaseSavepoint(savepoint);
  }

  @Override
  public void rollback() throws SQLException {
    conn.rollback();
  }

  @Override
  public void rollback(final Savepoint savepoint) throws SQLException {
    conn.rollback(savepoint);
  }

  @Override
  public void setClientInfo(final String name, final String value) throws SQLClientInfoException {
    conn.setClientInfo(name, value);
  }

  @Override
  public Savepoint setSavepoint() throws SQLException {
    return conn.setSavepoint();
  }

  @Override
  public Savepoint setSavepoint(final String name) throws SQLException {
    return conn.setSavepoint(name);
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T unwrap(final Class<T> iface) throws SQLException {
    if (iface.isAssignableFrom(getClass()))
      return (T) this;
    else
      return conn.unwrap(iface);
  }

  @Override
  public String getSchema() throws SQLException {
    return conn.getSchema();
  }

  @Override
  public void setSchema(String schema) throws SQLException {
    conn.setSchema(schema);
  }

  @Override
  public void abort(Executor executor) throws SQLException {
    conn.abort(executor);
  }

  @Override
  public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
    conn.setNetworkTimeout(executor, milliseconds);
  }

  @Override
  public int getNetworkTimeout() throws SQLException {
    return conn.getNetworkTimeout();
  }

}
