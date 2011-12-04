package com.filipovskii.aduplicator.algorithm;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


public final class HasherTest {

  private static final String str = "vatumba!";
  private Hasher m;

  @Before
  public void setUp() {
    m = new Hasher();
  }

  @Test
  public void canCountOneHashValue() throws Exception {
    m.feed(str);
    assertEquals(1, m.getHashCount(str));
  }

  @Test
  public void canCountMoreThanOneHashValue() throws Exception {
    m.feed(str);
    m.feed(str);
    assertEquals(2, m.getHashCount(str));
  }

  @Test
  public void zeroOccurrences() throws Exception {
    assertEquals(0, m.getHashCount(str));
  }
}
