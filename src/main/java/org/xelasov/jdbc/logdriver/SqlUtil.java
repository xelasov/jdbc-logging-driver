package org.xelasov.jdbc.logdriver;

import java.lang.reflect.Field;
import java.sql.Types;
import java.util.HashMap;

public class SqlUtil {

  private static final HashMap<Integer, String> sqlTypes = new HashMap<Integer, String>();

  static {
    for (final Field f : Types.class.getDeclaredFields()) {
      try {
        sqlTypes.put(f.getInt(null), f.getName());
      } catch (final IllegalArgumentException e) {
      } catch (final IllegalAccessException e) {
      }
    }
  }

  public static String getSqlTypeName(int sqlType) {
    return sqlTypes.get(sqlType);
  }

}
