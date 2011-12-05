package com.filipovskii.aduplicator.util;

import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Enumeration;

/**
 * Represents a {@link StreamTokenizer} with predefined syntax table
 */
public class CustomTokenizer implements Enumeration<String> {

  public static CustomTokenizer lineTokenizer(Reader reader) {
    StreamTokenizer tok = new StreamTokenizer(reader);
    // todo: tok table set up
    return new CustomTokenizer(tok);
  } 

  private final StreamTokenizer tokenizer;

  private CustomTokenizer(StreamTokenizer tokenizer) {
    this.tokenizer = tokenizer;
  }

  @Override
  public boolean hasMoreElements() {
    throw new UnsupportedOperationException();
  }
  
  @Override
  public String nextElement() {
    throw new UnsupportedOperationException();
  }

  
}
