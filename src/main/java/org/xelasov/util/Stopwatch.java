package org.xelasov.util;

public class Stopwatch {

  private long startMillis;
  private long stopMillis;

  public static Stopwatch createStarted() {
    return new Stopwatch(System.currentTimeMillis());
  }

  public static Stopwatch create() {
    return new Stopwatch();
  }

  protected Stopwatch() {
    this(0);
  }

  protected Stopwatch(long startMillis) {
    this.startMillis = startMillis;
  }

  public Stopwatch stop() {
    this.stopMillis = System.currentTimeMillis();
    return this;
  }

  public long elapsedMillis() {
    return stopMillis - startMillis;
  }

}
