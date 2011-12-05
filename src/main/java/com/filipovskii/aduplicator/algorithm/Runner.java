package com.filipovskii.aduplicator.algorithm;

import com.filipovskii.aduplicator.util.Provider;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import java.util.HashSet;
import java.util.Scanner;

public final class Runner implements Runnable {
  
  private final Hasher hasher;

  // Provider is used because we need to read the same data twice,
  // so we need to initialize Reader twice (I don't trust mark() and reset()).
  //
  // It is possible to use RandomAccessFile for such purposes,
  // but such solution cannot be elegantly tested.
  private final Provider<? extends Reader> readerProvider;
  private final BufferedWriter writer;
  private final String delimiter;

  private final HashSet<String> duplicateSet;

  public Runner(String delimiter, Provider<? extends Reader> provider, Writer w) {
    this.hasher = new Hasher();
    this.delimiter = delimiter;
    this.readerProvider = provider;
    this.writer = new BufferedWriter(w);
    this.duplicateSet = new HashSet<String>(); 
  }
  

  public void run() {
    Scanner scanner = null;
    try {

      scanner = createNewScanner();
      while (scanner.hasNext()) {
        String line = scanner.next();
        hasher.feed(line);
      }
      scanner.close();

      scanner = createNewScanner();
      while (scanner.hasNext()) {
        String line = scanner.next();
        // if line has a unique hash code or it hasn't been written yet
        if (hasher.getHashCount(line) == 1 || duplicateSet.add(line)) {
          writer.write(line);
          // todo: writes one extra delimiter in the end even there was no in
          // original data
          writer.write(delimiter);
        }
      }
    
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    finally {
      scanner.close();
      try {
        writer.close();
      } catch (IOException ignore) { }
    }
    
  }

  private Scanner createNewScanner() {
    Scanner sc = new Scanner(new BufferedReader(readerProvider.get()));
    sc.useDelimiter(delimiter);
    return sc;
  }

}
