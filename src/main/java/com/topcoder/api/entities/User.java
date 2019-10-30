/**
 * Copyright (c) 2019 TopCoder, Inc. All rights reserved.
 */
package com.topcoder.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The user entity, it is annotated with JPA @Entity and mapped with the "users" database table.
 * It extends IdentifiableEntity and additionally defines the 'handle' field and provides a getter and a setter for it.
 * 
 * @author TCSCODER
 * @version 1.0
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends IdentifiableEntity {
  /**
   * The user handle.
   */
  @NotNull
  @Column(unique = true)
  private String handle;
}