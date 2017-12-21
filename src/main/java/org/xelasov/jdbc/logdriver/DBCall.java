package org.xelasov.jdbc.logdriver;

import org.xelasov.util.Stopwatch;
import java.util.ArrayList;

public class DBCall {

  private String ur;
  private String sql;
  private Stopwatch timer;

  public static DBCall newJdbcCall(String sql, ArrayList<Parameter> parameters) {
    DBCall jdbcCall = new DBCall();
    jdbcCall.setSql(sql);
    jdbcCall.setTimer(Stopwatch.createStarted());
    return jdbcCall;
  }

  public static DBCall newJdbcCall(String sql) {
    DBCall jdbcCall = new DBCall();
    jdbcCall.setSql(sql);
    jdbcCall.setTimer(Stopwatch.createStarted());
    return jdbcCall;
  }

  public String getUr() {
    return ur;
  }

  public void setUr(String ur) {
    this.ur = ur;
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
