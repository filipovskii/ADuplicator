package com.filipovskii.aduplicator.util;

import java.io.Reader;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

public class CustomTokenizerTest {
  
  @Test
  public void construction() throws Exception {
    Reader r = createMock(Reader.class);
  }
}
