package org.xelasov.jdbc.logdriver;

public class Pair<K, V> {
  private final K key;
  private final V val;

  public Pair(K key, V val) {
    this.key = key;
    this.val = val;
  }

  public K getKey() {

    return key;
  }

  public V getValue() {
    return val;
  }
}


