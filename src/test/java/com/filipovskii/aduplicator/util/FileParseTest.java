package com.filipovskii.aduplicator.util;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.StreamTokenizer;

import org.junit.Test;
import static org.junit.Assert.*;

public class FileParseTest {
  
  @Test
  public void readChunkByChunk() throws Exception {
    Reader reader = new BufferedReader(
        new FileReader(new File("src/test/resources/test-data.txt")));
    StreamTokenizer tok = new StreamTokenizer(reader);
    tok.resetSyntax();
    tok.eolIsSignificant(true);
    tok.wordChars(Character.MIN_VALUE, Character.MAX_VALUE);
    while (StreamTokenizer.TT_EOF != tok.nextToken()) {
      System.out.println(tok.sval);
    }
    reader.close();
  }
}
