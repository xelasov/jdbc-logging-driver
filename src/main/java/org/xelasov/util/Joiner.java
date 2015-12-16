package org.xelasov.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Joiner {
  private final String dlm;
  private final String prefix;
  private final String suffix;

  private final ArrayList<String> list = new ArrayList<>();

  public Joiner(final String dlm, final String prefix, final String suffix) {
    this.dlm = getNonEmpty(dlm, "");
    this.prefix = getNonEmpty(prefix, "");
    this.suffix = getNonEmpty(suffix, "");
  }

  public String join(String... fields) {
    if (fields != null) {
      for (String s : fields)
        append(s);
    }
    return toString();
  }

  public void append(String v) {
    if (v != null)
      list.add(v);
  }

  public String toString() {
    return fieldsToString(prefix, list, dlm, suffix);
  }

  protected static String fieldsToString(final String prefix, final List<String> values, final String dlm, final String suffix) {
    // nulls are already handled
    final StringBuilder    sb     = new StringBuilder();
    final Iterator<String> fields = values.iterator();

    // prefix
    sb.append(prefix);

    // fields
    if (fields.hasNext())
      sb.append(fields.next());

    while (fields.hasNext()) {
      sb.append(dlm).append(fields.next());
    }

    // suffix
    sb.append(suffix);

    return sb.toString();
  }

  protected static String getNonEmpty(final String val, final String defVal) {
    return (val == null || val.isEmpty()) ? defVal : val;
  }
}
