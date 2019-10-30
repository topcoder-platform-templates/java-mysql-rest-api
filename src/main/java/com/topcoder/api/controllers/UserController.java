/**
 * Copyright (c) 2019 TopCoder, Inc. All rights reserved.
 */
package com.topcoder.api.controllers;

import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import com.topcoder.api.Utils;
import com.topcoder.api.entities.User;
import com.topcoder.api.entities.dtos.UserRequest;
import com.topcoder.api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller provides endpoints for user management.
 * 
 * @author TCSCODER
 * @version 1.0
 */
@RestController
@RequestMapping("/users")
public class UserController {
  /**
   * The user service used to manage user entity in the backend.
   * It is inject by Spring.
   */
  @Autowired
  private UserService userService;

  /**
   * Check if all the configuration parameters are properly initialized.
   * 
   * @throws ConfigurationException if userService is not properly initialized.
   */
  @PostConstruct
  public void init() {
    Utils.checkNull(userService, "userService");
  }

  /**
   * Handles the create user Http request.
   * 
   * @param request The UserRequest instance which holds the handle of the user to create.
   * @return The created User instance.
   */
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public User create(@Valid @RequestBody UserRequest request) {
    return userService.create(request);
  }

  /**
   * Handles the request for getting all available users.
   *
   * @return The list of all available users.
   */
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public List<User> getUsers() {
    return userService.getAllUsers();
  }

  /**
   * Handles the request for updating a user identified by the specified userId.
   * 
   * @param userId The id of the user to update.
   * @param request The UserRequest instance which holds the new hanlde of the user.
   * @return The updated User instance.
   */
  @PutMapping(path = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public User update(@PathVariable UUID userId, @Valid @RequestBody UserRequest request) {
    return userService.update(userId, request);
  }

  /**
   * Handles the request for deleting a single user identified by the given userId.
   * @param userId The id of the user to delete.
   */
  @DeleteMapping(path = "/{userId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable UUID userId) {
    userService.delete(userId);
  }
}