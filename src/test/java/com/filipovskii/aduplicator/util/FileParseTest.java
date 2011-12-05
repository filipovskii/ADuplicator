package com.filipovskii.aduplicator.util;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.StreamTokenizer;
import java.util.Scanner;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Set of tests for understanding different file parse methods
 */
public class FileParseTest {
  
  @Test
  public void streamReader() throws Exception {
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

  @Test
  public void scanner() throws Exception {
    Reader reader = new BufferedReader(
        new FileReader(new File("src/test/resources/test-data.txt")));
    Scanner sc = new Scanner(reader);
    // it is posible to use nextLine() method instead
    sc.useDelimiter("\n");
    while (sc.hasNext()) {
      String l = sc.next();
      assertTrue(l != null);
      assertTrue(l.length() > 0);
      System.out.println(l);
    }
  }
}
