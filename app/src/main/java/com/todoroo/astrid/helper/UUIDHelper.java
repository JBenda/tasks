package com.todoroo.astrid.helper;

import java.util.UUID;

public class UUIDHelper {

  private static final long MIN_UUID = 100000000;

  /** @return a pair consisting of the newly generated uuid and the corresponding proof text */
  public static String newUUID() {
    long uuid;
    final String PATTERN = "xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx";
    do {
      uuid = UUID.randomUUID().getLeastSignificantBits() & 0x7fffffffffffffffL;
    } while (uuid < MIN_UUID);
    StringBuilder uuid_str = new StringBuilder(Long.toString(uuid));
    for(int i = 0; i < uuid_str.length(); i += 1) {
      char p = PATTERN.charAt(i);
      if ('x' == p) { continue; }
      uuid_str.insert(i, p);
    }
    return uuid_str.toString();
  }
}
