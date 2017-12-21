package org.xelasov.jdbc.logdriver;

import org.xelasov.util.Stopwatch;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dz on 12/19/17.
 */
public class ParametrizedDBCall extends DBCall {

  private List<Parameter> parameters;

  public static ParametrizedDBCall newCall(String sql, ArrayList<Parameter> parameters) {
    ParametrizedDBCall jdbcCall = new ParametrizedDBCall();
    jdbcCall.setSql(sql);
    jdbcCall.setParameters(parameters);
    jdbcCall.setTimer(Stopwatch.createStarted());
    return jdbcCall;
  }

  protected String buildSqlString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("[sql=" + getSql());
    sb.append("; params=").append(Parameter.toLogString(getParameters()));
    return sb.toString();
  }

  public List<Parameter> getParameters() {
    return parameters;
  }

  public void setParameters(List<Parameter> parameters) {
    this.parameters = parameters;
  }

}
