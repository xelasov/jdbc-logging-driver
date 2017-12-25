package org.xelasov.jdbc.logdriver;

import org.xelasov.util.Stopwatch;
import java.util.ArrayList;

public class DBCall {

  private String sql;
  private Stopwatch timer;

  public static DBCall newJdbcCall(String sql) {
    DBCall jdbcCall = new DBCall();
    jdbcCall.setSql(sql);
    jdbcCall.setTimer(Stopwatch.createStarted());
    return jdbcCall;
  }

  public String getSql() {
    return sql;
  }

  public void setSql(String sql) {
    this.sql = sql;
  }

  public Stopwatch getTimer() {
    return timer;
  }

  public void setTimer(Stopwatch timer) {
    this.timer = timer;
  }
}
