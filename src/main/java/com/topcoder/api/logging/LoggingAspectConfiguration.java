/**
 * Copyright (c) 2019 TopCoder, Inc. All rights reserved.
 */
package com.topcoder.api.logging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Logging aspect configuration.
 * 
 * @author TCSCODER
 * @version 1.0
 */
@Configuration
@EnableAspectJAutoProxy
public class LoggingAspectConfiguration {
  /**
   * Create logging aspect bean.
   * 
   * @return the logging aspect bean
   */
  @Bean
  public LoggingAspect loggingAspect() {
    return new LoggingAspect();
  }
}