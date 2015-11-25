package org.xelasov.jdbc.logdriver;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;

public class LoggingCallableStatement extends LoggingPreparedStatement implements CallableStatement {

  private final CallableStatement cStmt;

  public LoggingCallableStatement(final LoggingConnection conn, final CallableStatement cStmt, final String sql) {
    super(conn, cStmt, sql);
    this.cStmt = cStmt;
  }

  @Override
  public Array getArray(final int parameterIndex) throws SQLException {
    return cStmt.getArray(parameterIndex);
  }

  @Override
  public Array getArray(final String parameterName) throws SQLException {
    return cStmt.getArray(parameterName);
  }

  @Override
  public BigDecimal getBigDecimal(final int parameterIndex) throws SQLException {
    return cStmt.getBigDecimal(parameterIndex);
  }

  @SuppressWarnings("deprecation")
  @Override
  public BigDecimal getBigDecimal(final int parameterIndex, final int scale) throws SQLException {
    return cStmt.getBigDecimal(parameterIndex, scale);
  }

  @Override
  public BigDecimal getBigDecimal(final String parameterName) throws SQLException {
    return cStmt.getBigDecimal(parameterName);
  }

  @Override
  public Blob getBlob(final int parameterIndex) throws SQLException {
    return cStmt.getBlob(parameterIndex);
  }

  @Override
  public Blob getBlob(final String parameterName) throws SQLException {
    return cStmt.getBlob(parameterName);
  }

  @Override
  public boolean getBoolean(final int parameterIndex) throws SQLException {
    return cStmt.getBoolean(parameterIndex);
  }

  @Override
  public boolean getBoolean(final String parameterName) throws SQLException {
    return cStmt.getBoolean(parameterName);
  }

  @Override
  public byte getByte(final int parameterIndex) throws SQLException {
    return cStmt.getByte(parameterIndex);
  }

  @Override
  public byte getByte(final String parameterName) throws SQLException {
    return cStmt.getByte(parameterName);
  }

  @Override
  public byte[] getBytes(final int parameterIndex) throws SQLException {
    return cStmt.getBytes(parameterIndex);
  }

  @Override
  public byte[] getBytes(final String parameterName) throws SQLException {
    return cStmt.getBytes(parameterName);
  }

  @Override
  public Reader getCharacterStream(final int parameterIndex) throws SQLException {
    return cStmt.getCharacterStream(parameterIndex);
  }

  @Override
  public Reader getCharacterStream(final String parameterName) throws SQLException {
    return cStmt.getCharacterStream(parameterName);
  }

  @Override
  public Clob getClob(final int parameterIndex) throws SQLException {
    return cStmt.getClob(parameterIndex);
  }

  @Override
  public Clob getClob(final String parameterName) throws SQLException {
    return cStmt.getClob(parameterName);
  }

  @Override
  public Connection getConnection() throws SQLException {
    return cStmt.getConnection();
  }

  @Override
  public Date getDate(final int parameterIndex) throws SQLException {
    return cStmt.getDate(parameterIndex);
  }

  @Override
  public Date getDate(final int parameterIndex, final Calendar cal) throws SQLException {
    return cStmt.getDate(parameterIndex, cal);
  }

  @Override
  public Date getDate(final String parameterName) throws SQLException {
    return cStmt.getDate(parameterName);
  }

  @Override
  public Date getDate(final String parameterName, final Calendar cal) throws SQLException {
    return cStmt.getDate(parameterName, cal);
  }

  @Override
  public double getDouble(final int parameterIndex) throws SQLException {
    return cStmt.getDouble(parameterIndex);
  }

  @Override
  public double getDouble(final String parameterName) throws SQLException {
    return cStmt.getDouble(parameterName);
  }

  @Override
  public int getFetchDirection() throws SQLException {
    return cStmt.getFetchDirection();
  }

  @Override
  public int getFetchSize() throws SQLException {
    return cStmt.getFetchSize();
  }

  @Override
  public float getFloat(final int parameterIndex) throws SQLException {
    return cStmt.getFloat(parameterIndex);
  }

  @Override
  public float getFloat(final String parameterName) throws SQLException {
    return cStmt.getFloat(parameterName);
  }

  @Override
  public ResultSet getGeneratedKeys() throws SQLException {
    return cStmt.getGeneratedKeys();
  }

  @Override
  public int getInt(final int parameterIndex) throws SQLException {
    return cStmt.getInt(parameterIndex);
  }

  @Override
  public int getInt(final String parameterName) throws SQLException {
    return cStmt.getInt(parameterName);
  }

  @Override
  public long getLong(final int parameterIndex) throws SQLException {
    return cStmt.getLong(parameterIndex);
  }

  @Override
  public long getLong(final String parameterName) throws SQLException {
    return cStmt.getLong(parameterName);
  }

  @Override
  public Reader getNCharacterStream(final int parameterIndex) throws SQLException {
    return cStmt.getNCharacterStream(parameterIndex);
  }

  @Override
  public Reader getNCharacterStream(final String parameterName) throws SQLException {
    return cStmt.getNCharacterStream(parameterName);
  }

  @Override
  public NClob getNClob(final int parameterIndex) throws SQLException {
    return cStmt.getNClob(parameterIndex);
  }

  @Override
  public NClob getNClob(final String parameterName) throws SQLException {
    return cStmt.getNClob(parameterName);
  }

  @Override
  public String getNString(final int parameterIndex) throws SQLException {
    return cStmt.getNString(parameterIndex);
  }

  @Override
  public String getNString(final String parameterName) throws SQLException {
    return cStmt.getNString(parameterName);
  }

  @Override
  public Object getObject(final int parameterIndex) throws SQLException {
    return cStmt.getObject(parameterIndex);
  }

  @Override
  public Object getObject(final int parameterIndex, final Map<String, Class<?>> map) throws SQLException {
    return cStmt.getObject(parameterIndex, map);
  }

  @Override
  public Object getObject(final String parameterName) throws SQLException {
    return cStmt.getObject(parameterName);
  }

  @Override
  public Object getObject(final String parameterName, final Map<String, Class<?>> map) throws SQLException {
    return cStmt.getObject(parameterName, map);
  }

  @Override
  public <T> T getObject(int parameterIndex, Class<T> type) throws SQLException {
    return cStmt.getObject(parameterIndex, type);
  }

  @Override
  public <T> T getObject(String parameterName, Class<T> type) throws SQLException {
    return cStmt.getObject(parameterName, type);
  }

  @Override
  public Ref getRef(final int parameterIndex) throws SQLException {
    return cStmt.getRef(parameterIndex);
  }

  @Override
  public Ref getRef(final String parameterName) throws SQLException {
    return cStmt.getRef(parameterName);
  }

  @Override
  public RowId getRowId(final int parameterIndex) throws SQLException {
    return cStmt.getRowId(parameterIndex);
  }

  @Override
  public RowId getRowId(final String parameterName) throws SQLException {
    return cStmt.getRowId(parameterName);
  }

  @Override
  public short getShort(final int parameterIndex) throws SQLException {
    return cStmt.getShort(parameterIndex);
  }

  @Override
  public short getShort(final String parameterName) throws SQLException {
    return cStmt.getShort(parameterName);
  }

  @Override
  public SQLXML getSQLXML(final int parameterIndex) throws SQLException {
    return cStmt.getSQLXML(parameterIndex);
  }

  @Override
  public SQLXML getSQLXML(final String parameterName) throws SQLException {
    return cStmt.getSQLXML(parameterName);
  }

  @Override
  public String getString(final int parameterIndex) throws SQLException {
    return cStmt.getString(parameterIndex);
  }

  @Override
  public String getString(final String parameterName) throws SQLException {
    return cStmt.getString(parameterName);
  }

  @Override
  public Time getTime(final int parameterIndex) throws SQLException {
    return cStmt.getTime(parameterIndex);
  }

  @Override
  public Time getTime(final int parameterIndex, final Calendar cal) throws SQLException {
    return cStmt.getTime(parameterIndex, cal);
  }

  @Override
  public Time getTime(final String parameterName) throws SQLException {
    return cStmt.getTime(parameterName);
  }

  @Override
  public Time getTime(final String parameterName, final Calendar cal) throws SQLException {
    return cStmt.getTime(parameterName, cal);
  }

  @Override
  public Timestamp getTimestamp(final int parameterIndex) throws SQLException {
    return cStmt.getTimestamp(parameterIndex);
  }

  @Override
  public Timestamp getTimestamp(final int parameterIndex, final Calendar cal) throws SQLException {
    return cStmt.getTimestamp(parameterIndex, cal);
  }

  @Override
  public Timestamp getTimestamp(final String parameterName) throws SQLException {
    return cStmt.getTimestamp(parameterName);
  }

  @Override
  public Timestamp getTimestamp(final String parameterName, final Calendar cal) throws SQLException {
    return cStmt.getTimestamp(parameterName, cal);
  }

  @Override
  public URL getURL(final int parameterIndex) throws SQLException {
    return cStmt.getURL(parameterIndex);
  }

  @Override
  public URL getURL(final String parameterName) throws SQLException {
    return cStmt.getURL(parameterName);
  }

  @Override
  public void registerOutParameter(final int parameterIndex, final int sqlType) throws SQLException {
    setParam(Parameter.makeOutParam(parameterIndex, sqlType));
    cStmt.registerOutParameter(parameterIndex, sqlType);
  }

  @Override
  public void registerOutParameter(final int parameterIndex, final int sqlType, final int scale) throws SQLException {
    setParam(Parameter.makeOutParam(parameterIndex, sqlType));
    cStmt.registerOutParameter(parameterIndex, sqlType, scale);
  }

  @Override
  public void registerOutParameter(final int parameterIndex, final int sqlType, final String typeName) throws SQLException {
    setParam(Parameter.makeOutParam(parameterIndex, sqlType));
    cStmt.registerOutParameter(parameterIndex, sqlType, typeName);
  }

  @Override
  public void registerOutParameter(final String parameterName, final int sqlType) throws SQLException {
    setParam(Parameter.makeOutParam(parameterName, sqlType));
    cStmt.registerOutParameter(parameterName, sqlType);
  }

  @Override
  public void registerOutParameter(final String parameterName, final int sqlType, final int scale) throws SQLException {
    setParam(Parameter.makeOutParam(parameterName, sqlType));
    cStmt.registerOutParameter(parameterName, sqlType, scale);
  }

  @Override
  public void registerOutParameter(final String parameterName, final int sqlType, final String typeName) throws SQLException {
    setParam(Parameter.makeOutParam(parameterName, sqlType));
    cStmt.registerOutParameter(parameterName, sqlType, typeName);
  }

  @Override
  public void setAsciiStream(final String parameterName, final InputStream x) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, InputStream.class, x));
    cStmt.setAsciiStream(parameterName, x);
  }

  @Override
  public void setAsciiStream(final String parameterName, final InputStream x, final int length) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, InputStream.class, x));
    cStmt.setAsciiStream(parameterName, x, length);
  }

  @Override
  public void setAsciiStream(final String parameterName, final InputStream x, final long length) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, InputStream.class, x));
    cStmt.setAsciiStream(parameterName, x, length);
  }

  @Override
  public void setBigDecimal(final String parameterName, final BigDecimal x) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, BigDecimal.class, x));
    cStmt.setBigDecimal(parameterName, x);
  }

  @Override
  public void setBinaryStream(final String parameterName, final InputStream x) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, InputStream.class, x));
    cStmt.setBinaryStream(parameterName, x);
  }

  @Override
  public void setBinaryStream(final String parameterName, final InputStream x, final int length) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, InputStream.class, x));
    cStmt.setBinaryStream(parameterName, x, length);
  }

  @Override
  public void setBinaryStream(final String parameterName, final InputStream x, final long length) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, InputStream.class, x));
    cStmt.setBinaryStream(parameterName, x, length);
  }

  @Override
  public void setBlob(final String parameterName, final Blob x) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Blob.class, x));
    cStmt.setBlob(parameterName, x);
  }

  @Override
  public void setBlob(final String parameterName, final InputStream inputStream) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, InputStream.class, inputStream));
    cStmt.setBlob(parameterName, inputStream);
  }

  @Override
  public void setBlob(final String parameterName, final InputStream inputStream, final long length) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, InputStream.class, inputStream));
    cStmt.setBlob(parameterName, inputStream, length);
  }

  @Override
  public void setBoolean(final String parameterName, final boolean x) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Boolean.class, x));
    cStmt.setBoolean(parameterName, x);
  }

  @Override
  public void setByte(final String parameterName, final byte x) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Byte.class, x));
    cStmt.setByte(parameterName, x);
  }

  @Override
  public void setBytes(final String parameterName, final byte[] x) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Byte[].class, x));
    cStmt.setBytes(parameterName, x);
  }

  @Override
  public void setCharacterStream(final String parameterName, final Reader reader) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Reader.class, reader));
    cStmt.setCharacterStream(parameterName, reader);
  }

  @Override
  public void setCharacterStream(final String parameterName, final Reader reader, final int length) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Reader.class, reader));
    cStmt.setCharacterStream(parameterName, reader, length);
  }

  @Override
  public void setCharacterStream(final String parameterName, final Reader reader, final long length) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Reader.class, reader));
    cStmt.setCharacterStream(parameterName, reader, length);
  }

  @Override
  public void setClob(final String parameterName, final Clob x) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Clob.class, x));
    cStmt.setClob(parameterName, x);
  }

  @Override
  public void setClob(final String parameterName, final Reader reader) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Reader.class, reader));
    cStmt.setClob(parameterName, reader);
  }

  @Override
  public void setClob(final String parameterName, final Reader reader, final long length) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Reader.class, reader));
    cStmt.setClob(parameterName, reader, length);
  }

  @Override
  public void setDate(final String parameterName, final Date x) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Date.class, x));
    cStmt.setDate(parameterName, x);
  }

  @Override
  public void setDate(final String parameterName, final Date x, final Calendar cal) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Date.class, x));
    cStmt.setDate(parameterName, x, cal);
  }

  @Override
  public void setDouble(final String parameterName, final double x) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Double.class, x));
    cStmt.setDouble(parameterName, x);
  }

  @Override
  public void setFloat(final String parameterName, final float x) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Float.class, x));
    cStmt.setFloat(parameterName, x);
  }

  @Override
  public void setInt(final String parameterName, final int x) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Integer.class, x));
    cStmt.setInt(parameterName, x);
  }

  @Override
  public void setLong(final String parameterName, final long x) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Long.class, x));
    cStmt.setLong(parameterName, x);
  }

  @Override
  public void setNCharacterStream(final String parameterName, final Reader value) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Reader.class, value));
    cStmt.setNCharacterStream(parameterName, value);
  }

  @Override
  public void setNCharacterStream(final String parameterName, final Reader value, final long length) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Reader.class, value));
    cStmt.setNCharacterStream(parameterName, value, length);
  }

  @Override
  public void setNClob(final String parameterName, final NClob value) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, NClob.class, value));
    cStmt.setNClob(parameterName, value);
  }

  @Override
  public void setNClob(final String parameterName, final Reader reader) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Reader.class, reader));
    cStmt.setNClob(parameterName, reader);
  }

  @Override
  public void setNClob(final String parameterName, final Reader reader, final long length) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Reader.class, reader));
    cStmt.setNClob(parameterName, reader, length);
  }

  @Override
  public void setNString(final String parameterName, final String value) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, String.class, value));
    cStmt.setNString(parameterName, value);
  }

  @Override
  public void setNull(final String parameterName, final int sqlType, final String typeName) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, sqlType, null));
    cStmt.setNull(parameterName, sqlType, typeName);
  }

  @Override
  public void setNull(String parameterName, int sqlType) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, sqlType, null));
    cStmt.setNull(parameterName, sqlType);
  }

  @Override
  public void setObject(final String parameterName, final Object x) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, x));
    cStmt.setObject(parameterName, x);
  }

  @Override
  public void setObject(final String parameterName, final Object x, final int targetSqlType) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, targetSqlType, x));
    cStmt.setObject(parameterName, x, targetSqlType);
  }

  @Override
  public void setObject(final String parameterName, final Object x, final int targetSqlType, final int scale) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, targetSqlType, x));
    cStmt.setObject(parameterName, x, targetSqlType, scale);
  }

  @Override
  public void setRowId(final String parameterName, final RowId x) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, RowId.class, x));
    cStmt.setRowId(parameterName, x);
  }

  @Override
  public void setShort(final String parameterName, final short x) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Short.class, x));
    cStmt.setShort(parameterName, x);
  }

  @Override
  public void setSQLXML(final String parameterName, final SQLXML xmlObject) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, SQLXML.class, xmlObject));
    cStmt.setSQLXML(parameterName, xmlObject);
  }

  @Override
  public void setString(final String parameterName, final String x) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, String.class, x));
    cStmt.setString(parameterName, x);
  }

  @Override
  public void setTime(final String parameterName, final Time x) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Time.class, x));
    cStmt.setTime(parameterName, x);
  }

  @Override
  public void setTime(final String parameterName, final Time x, final Calendar cal) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Time.class, x));
    cStmt.setTime(parameterName, x, cal);
  }

  @Override
  public void setTimestamp(final String parameterName, final Timestamp x) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Timestamp.class, x));
    cStmt.setTimestamp(parameterName, x);
  }

  @Override
  public void setTimestamp(final String parameterName, final Timestamp x, final Calendar cal) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, Timestamp.class, x));
    cStmt.setTimestamp(parameterName, x, cal);
  }

  @Override
  public void setURL(final String parameterName, final URL val) throws SQLException {
    setParam(Parameter.makeInParam(parameterName, URL.class, val));
    cStmt.setURL(parameterName, val);
  }

  @Override
  public boolean wasNull() throws SQLException {
    return cStmt.wasNull();
  }

  @Override
  public void closeOnCompletion() throws SQLException {
    this.cStmt.closeOnCompletion();
  }

  @Override
  public boolean isCloseOnCompletion() throws SQLException {
    return cStmt.isCloseOnCompletion();
  }

}
