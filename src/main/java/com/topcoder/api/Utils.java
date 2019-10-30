/*
 * Copyright (C) 2019 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.api;

import com.topcoder.api.exceptions.ConfigurationException;

/**
 * This class contains utility methods of the application.
 *
 * @author TCSCODER
 * @version 1.0
 */
public final class Utils {
  /**
   * Private constructor to prevent instantiation.
   */
  private Utils() {
  }

  /**
   * Validates the specified value to be not null.
   *
   * @param value The value to be validated.
   * @param name  The name of the variable to be validated.
   * @throws ConfigurationException if the the variable is null.
   */
  public static void checkNull(Object value, String name) {
    if (value == null) {
      // Log exception
      throw new ConfigurationException("'" + name + "' should not be null.");
    }
  }
}
