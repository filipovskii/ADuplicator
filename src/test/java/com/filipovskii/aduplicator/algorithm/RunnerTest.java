package com.filipovskii.aduplicator.algorithm;

import com.filipovskii.aduplicator.util.Provider; 

import java.io.Reader;
import java.io.StringWriter;
import java.io.StringReader;

import org.junit.Test;
import static org.junit.Assert.*;

public class RunnerTest {

  @Test
  public void oneLineRun() throws Exception {
    final String line = "bla bla";
    String delim = " ";
    StringWriter w = new StringWriter();

    Provider<Reader> provider = new Provider<Reader>() {
      
      public Reader get() {
        return new StringReader(line);
      }

    };

    Runner runner = new Runner(delim, provider, w);
    runner.run();

    assertEquals("bla ", w.toString());

  }
}
