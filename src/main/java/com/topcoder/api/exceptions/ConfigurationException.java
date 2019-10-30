/*
 * Copyright (C) 2019 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.api.exceptions;

/**
 * This exception will be thrown to indicate any configuration error.
 *
 * @author TCSCODER
 * @version 1.0
 */
public class ConfigurationException extends ApplicationBaseException {
  /**
   * The default serial version UID.
   */
  private static final long serialVersionUID = -6473384464569313660L;

  /**
   * Constructor with message parameter.
   *
   * @param message The error message of the exception.
   */
  public ConfigurationException(String message) {
    super(message);
  }

  /**
   * Constructor with message and cause parameters.
   *
   * @param message The error message of the exception.
   * @param cause   The root cause of the exception.
   */
  public ConfigurationException(String message, Throwable cause) {
    super(message, cause);
  }
}