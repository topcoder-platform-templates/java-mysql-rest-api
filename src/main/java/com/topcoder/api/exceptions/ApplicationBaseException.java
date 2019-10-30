/*
 * Copyright (C) 2019 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.api.exceptions;

/**
 * This exception is a base exception of all exceptions to be defined in the application.
 *
 * @author TCSCODER
 * @version 1.0
 */
public class ApplicationBaseException extends RuntimeException {
  /**
   * The default serial version UID.
   */
  private static final long serialVersionUID = 231108967133826696L;

  /**
   * Constructor with message parameter.
   *
   * @param message The error message of the exception.
   */
  public ApplicationBaseException(String message) {
    super(message);
  }

  /**
   * Constructor with message and cause parameters.
   *
   * @param message The error message of the exception.
   * @param cause   The root cause of the exception.
   */
  public ApplicationBaseException(String message, Throwable cause) {
    super(message, cause);
  }
}