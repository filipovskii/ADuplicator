package com.filipovskii.aduplicator.algorithm;

import java.util.Map;
import java.util.HashMap;


public final class Hasher {

  /**
   * Stores count of identical hashes of feeded strings
   * todo: maybe use other structure
   */
  private Map<Integer, Integer> counter;
  
  public Hasher() {
    counter = new HashMap<Integer, Integer>();
  }

  public void feed(String str) {
    Integer currCount = counter.get(str.hashCode());
    counter.put(str.hashCode(), isNull(currCount, 0) + 1);
  }

  public int getHashCount(String str) {
    return isNull(counter.get(str.hashCode()), 0);
  }

  private int isNull(Integer val, int other) {
    return val == null ? other : val;
  }
  
}
