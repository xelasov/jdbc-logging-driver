package org.xelasov.jdbc.logdriver;

import java.lang.reflect.Field;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Parameter {
  protected static final HashMap<Integer, String> sqlTypes = new HashMap<>();

  static {
    for (final Field f : Types.class.getDeclaredFields()) {
      try {
        sqlTypes.put(f.getInt(null), f.getName());
      } catch (final IllegalArgumentException | IllegalAccessException e) {
      }
    }
  }

  protected static String getSqlTypeName(int sqlType) {
    return sqlTypes.get(sqlType);
  }

  public static Parameter makeInParam(int parameterIndex, Class<?> type, Object v) {
    return makeInParam(Integer.toString(parameterIndex), type, v);
  }

  public static Parameter makeInParam(String parameterName, Class<?> type, Object v) {
    return new Parameter(Direction.IN, parameterName, type.getSimpleName(), Objects.toString(v, "<null>"));
  }

  public static Parameter makeInParam(int parameterIndex, final int sqlType, Object v) {
    return makeInParam(Integer.toString(parameterIndex), sqlType, v);
  }

  public static Parameter makeInParam(String parameterName, final int sqlType, Object v) {
    return new Parameter(Direction.IN, parameterName, getSqlTypeName(sqlType), Objects.toString(v, "<null>"));
  }

  public static Parameter makeInParam(int parameterIndex, Object v) {
    return makeInParam(Integer.toString(parameterIndex), v);
  }

  public static Parameter makeInParam(String parameterName, Object v) {
    final String type = v == null ? "Object" : v.getClass().getSimpleName();
    return new Parameter(Direction.IN, parameterName, type, Objects.toString(v, "<null>"));
  }

  public static Parameter makeOutParam(int parameterIndex, int sqlType) {
    return makeOutParam(Integer.toString(parameterIndex), sqlType);
  }

  public static Parameter makeOutParam(String parameterName, int sqlType) {
    return new Parameter(Direction.OUT, parameterName, getSqlTypeName(sqlType), null);
  }

  public static String toLogString(List<Parameter> params) {
    final StringJoiner sj = new StringJoiner(",", "[", "]");
    params.stream().map(p -> p.toLogString()).forEach(s -> sj.add(s));
    return sj.toString();
  }


  protected enum Direction {
    IN,
    OUT,
  }

  private final Direction dir;
  private final String    id;
  private final String    type;
  private final String    val;


  private Parameter(final Direction dir, final String id, final String type, final String val) {
    this.dir = dir;
    this.id = id;
    this.type = type;
    this.val = val;
  }

  public String toLogString() {
    //final Joiner joiner = Joiner.on(":").skipNulls();
    //return "<" + joiner.join(id, dir, type, val) + ">";
    final StringJoiner sj = new StringJoiner(":", "<", ">");
    return sj.add(id).add(dir.name()).add(type).add(val).toString();
  }

}
