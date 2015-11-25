package org.xelasov.jdbc.logdriver;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Joiner;
import com.google.common.base.Stopwatch;

public class LoggingPreparedStatement extends LoggingStatement implements PreparedStatement {

  protected final PreparedStatement    pStmt;
  protected final String               sql;
  protected final ArrayList<Parameter> params;

  public LoggingPreparedStatement(final LoggingConnection conn, final PreparedStatement pStmt, final String sql) {
    super(conn, pStmt);
    this.pStmt = pStmt;
    this.params = new ArrayList<>(20);
    this.sql = sql;
  }

  protected void log(final String sql, final List<Parameter> params, final LoggingConnection conn, final Stopwatch timer) {
    log(buildSqlStr(sql, params), conn, timer);
  }

  protected void log(final String sql, final List<Parameter> params, final LoggingConnection conn, final Stopwatch timer, final Throwable e) {
    log(buildSqlStr(sql, params), conn, timer, e);
  }

  protected void setParam(Parameter p) {
    this.params.add(p);
  }

  protected static String buildSqlStr(String sql, List<Parameter> params) {
    final Joiner joiner = Joiner.on(", ").skipNulls();
    final StringBuilder sb = new StringBuilder();
    sb.append("[sql=" + sql);
    sb.append("; params=[");
    sb.append(joiner.join(params));
    sb.append("]");
    return sb.toString();
  }

  @Override
  public void addBatch() throws SQLException {
    pStmt.addBatch();
  }

  @Override
  public void clearParameters() throws SQLException {
    params.clear();
    pStmt.clearParameters();
  }

  @Override
  public boolean execute() throws SQLException {
    final Stopwatch timer = Stopwatch.createStarted();
    try {
      final boolean rv = pStmt.execute();
      log(sql, params, conn, timer);
      return rv;
    } catch (final SQLException | RuntimeException e) {
      log(sql, params, conn, timer, e);
      throw e;
    }
  }

  @Override
  public ResultSet executeQuery() throws SQLException {
    final Stopwatch timer = Stopwatch.createStarted();
    try {
      final ResultSet rv = pStmt.executeQuery();
      log(sql, params, conn, timer);
      return rv;
    } catch (final SQLException | RuntimeException e) {
      log(sql, params, conn, timer, e);
      throw e;
    }
  }

  @Override
  public int executeUpdate() throws SQLException {
    final Stopwatch timer = Stopwatch.createStarted();
    try {
      final int rv = pStmt.executeUpdate();
      log(sql, params, conn, timer);
      return rv;
    } catch (final SQLException | RuntimeException e) {
      log(sql, params, conn, timer, e);
      throw e;
    }
  }

  @Override
  public ResultSetMetaData getMetaData() throws SQLException {
    return pStmt.getMetaData();
  }

  @Override
  public ParameterMetaData getParameterMetaData() throws SQLException {
    return pStmt.getParameterMetaData();
  }

  @Override
  public void setArray(final int parameterIndex, final Array x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Array.class, x));
    pStmt.setArray(parameterIndex, x);
  }

  @Override
  public void setAsciiStream(final int parameterIndex, final InputStream x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, InputStream.class, x));
    pStmt.setAsciiStream(parameterIndex, x);
  }

  @Override
  public void setAsciiStream(final int parameterIndex, final InputStream x, final int length) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, InputStream.class, x));
    pStmt.setAsciiStream(parameterIndex, x, length);
  }

  @Override
  public void setAsciiStream(final int parameterIndex, final InputStream x, final long length) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, InputStream.class, x));
    pStmt.setAsciiStream(parameterIndex, x, length);
  }

  @Override
  public void setBigDecimal(final int parameterIndex, final BigDecimal x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, BigDecimal.class, x));
    pStmt.setBigDecimal(parameterIndex, x);
  }

  @Override
  public void setBinaryStream(final int parameterIndex, final InputStream x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, InputStream.class, x));
    pStmt.setBinaryStream(parameterIndex, x);
  }

  @Override
  public void setBinaryStream(final int parameterIndex, final InputStream x, final int length) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, InputStream.class, x));
    pStmt.setBinaryStream(parameterIndex, x, length);
  }

  @Override
  public void setBinaryStream(final int parameterIndex, final InputStream x, final long length) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, InputStream.class, x));
    pStmt.setBinaryStream(parameterIndex, x, length);
  }

  @Override
  public void setBlob(final int parameterIndex, final Blob x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Blob.class, x));
    pStmt.setBlob(parameterIndex, x);
  }

  @Override
  public void setBlob(final int parameterIndex, final InputStream inputStream) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, InputStream.class, inputStream));
    pStmt.setBlob(parameterIndex, inputStream);
  }

  @Override
  public void setBlob(final int parameterIndex, final InputStream inputStream, final long length) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, InputStream.class, inputStream));
    pStmt.setBlob(parameterIndex, inputStream, length);
  }

  @Override
  public void setBoolean(final int parameterIndex, final boolean x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Boolean.class, x));
    pStmt.setBoolean(parameterIndex, x);
  }

  @Override
  public void setByte(final int parameterIndex, final byte x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Byte.class, x));
    pStmt.setByte(parameterIndex, x);
  }

  @Override
  public void setBytes(final int parameterIndex, final byte[] x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Byte[].class, x));
    pStmt.setBytes(parameterIndex, x);
  }

  @Override
  public void setCharacterStream(final int parameterIndex, final Reader reader) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Reader.class, reader));
    pStmt.setCharacterStream(parameterIndex, reader);
  }

  @Override
  public void setCharacterStream(final int parameterIndex, final Reader reader, final int length) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Reader.class, reader));
    pStmt.setCharacterStream(parameterIndex, reader, length);
  }

  @Override
  public void setCharacterStream(final int parameterIndex, final Reader reader, final long length) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Reader.class, reader));
    pStmt.setCharacterStream(parameterIndex, reader, length);
  }

  @Override
  public void setClob(final int parameterIndex, final Clob x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Clob.class, x));
    pStmt.setClob(parameterIndex, x);
  }

  @Override
  public void setClob(final int parameterIndex, final Reader reader) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Reader.class, reader));
    pStmt.setClob(parameterIndex, reader);
  }

  @Override
  public void setClob(final int parameterIndex, final Reader reader, final long length) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Reader.class, reader));
    pStmt.setClob(parameterIndex, reader, length);
  }

  @Override
  public void setDate(final int parameterIndex, final Date x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Date.class, x));
    pStmt.setDate(parameterIndex, x);
  }

  @Override
  public void setDate(final int parameterIndex, final Date x, final Calendar cal) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Date.class, x));
    pStmt.setDate(parameterIndex, x, cal);
  }

  @Override
  public void setDouble(final int parameterIndex, final double x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Double.class, x));
    pStmt.setDouble(parameterIndex, x);
  }

  @Override
  public void setFloat(final int parameterIndex, final float x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Float.class, x));
    pStmt.setFloat(parameterIndex, x);
  }

  @Override
  public void setInt(final int parameterIndex, final int x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Integer.class, x));
    pStmt.setInt(parameterIndex, x);
  }

  @Override
  public void setLong(final int parameterIndex, final long x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Long.class, x));
    pStmt.setLong(parameterIndex, x);
  }

  @Override
  public void setNCharacterStream(final int parameterIndex, final Reader value) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Reader.class, value));
    pStmt.setNCharacterStream(parameterIndex, value);
  }

  @Override
  public void setNCharacterStream(final int parameterIndex, final Reader value, final long length) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Reader.class, value));
    pStmt.setNCharacterStream(parameterIndex, value, length);
  }

  @Override
  public void setNClob(final int parameterIndex, final NClob x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, NClob.class, x));
    pStmt.setNClob(parameterIndex, x);
  }

  @Override
  public void setNClob(final int parameterIndex, final Reader reader) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Reader.class, reader));
    pStmt.setNClob(parameterIndex, reader);
  }

  @Override
  public void setNClob(final int parameterIndex, final Reader reader, final long length) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Reader.class, reader));
    pStmt.setNClob(parameterIndex, reader, length);
  }

  @Override
  public void setNString(final int parameterIndex, final String value) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, String.class, value));
    pStmt.setNString(parameterIndex, value);
  }

  @Override
  public void setNull(final int parameterIndex, final int sqlType) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, sqlType, null));
    pStmt.setNull(parameterIndex, sqlType);
  }

  @Override
  public void setNull(final int parameterIndex, final int sqlType, final String typeName) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, sqlType, null));
    pStmt.setNull(parameterIndex, sqlType, typeName);
  }

  @Override
  public void setObject(final int parameterIndex, final Object x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, x));
    pStmt.setObject(parameterIndex, x);
  }

  @Override
  public void setObject(final int parameterIndex, final Object x, final int targetSqlType) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, targetSqlType, x));
    pStmt.setObject(parameterIndex, x, targetSqlType);
  }

  @Override
  public void setObject(final int parameterIndex, final Object x, final int targetSqlType, final int scaleOrLength) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, targetSqlType, x));
    pStmt.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
  }

  @Override
  public void setRef(final int parameterIndex, final Ref x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Ref.class, x));
    pStmt.setRef(parameterIndex, x);
  }

  @Override
  public void setRowId(final int parameterIndex, final RowId x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, RowId.class, x));
    pStmt.setRowId(parameterIndex, x);
  }

  @Override
  public void setShort(final int parameterIndex, final short x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Short.class, x));
    pStmt.setShort(parameterIndex, x);
  }

  @Override
  public void setSQLXML(final int parameterIndex, final SQLXML xmlObject) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, SQLXML.class, xmlObject));
    pStmt.setSQLXML(parameterIndex, xmlObject);
  }

  @Override
  public void setString(final int parameterIndex, final String x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, String.class, x));
    pStmt.setString(parameterIndex, x);
  }

  @Override
  public void setTime(final int parameterIndex, final Time x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Time.class, x));
    pStmt.setTime(parameterIndex, x);
  }

  @Override
  public void setTime(final int parameterIndex, final Time x, final Calendar cal) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Time.class, x));
    pStmt.setTime(parameterIndex, x, cal);
  }

  @Override
  public void setTimestamp(final int parameterIndex, final Timestamp x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Timestamp.class, x));
    pStmt.setTimestamp(parameterIndex, x);
  }

  @Override
  public void setTimestamp(final int parameterIndex, final Timestamp x, final Calendar cal) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, Timestamp.class, x));
    pStmt.setTimestamp(parameterIndex, x, cal);
  }

  @SuppressWarnings("deprecation")
  @Override
  public void setUnicodeStream(final int parameterIndex, final InputStream x, final int length) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, InputStream.class, x));
    pStmt.setUnicodeStream(parameterIndex, x, length);
  }

  @Override
  public void setURL(final int parameterIndex, final URL x) throws SQLException {
    setParam(Parameter.makeInParam(parameterIndex, URL.class, x));
    pStmt.setURL(parameterIndex, x);
  }

}
