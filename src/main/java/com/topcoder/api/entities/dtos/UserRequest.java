/**
 * Copyright (c) 2019 TopCoder, Inc. All rights reserved.
 */
package com.topcoder.api.entities.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class is a simple data transfer object which holds the user handle.
 * It provides a getter and a setter for the defined field.
 * 
 * @author TCSCODER
 * @version 1.0
 */
@Getter
@Setter
@ToString
public class UserRequest {
  /**
   * 
   * The user handle.
   */
  @NotBlank
  private String handle;
}