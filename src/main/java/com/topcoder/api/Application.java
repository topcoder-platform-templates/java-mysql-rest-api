/**
 * Copyright (c) 2019 TopCoder, Inc. All rights reserved.
 */
package com.topcoder.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Spring boot application main class.
 * 
 * @author TCSCODER
 * @version 1.0
 */
@SpringBootApplication
public class Application {

  /**
   * The main entry of the application.
   * 
   * @param args the arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
