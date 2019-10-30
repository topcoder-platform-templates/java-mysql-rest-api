/**
 * Copyright (c) 2019 TopCoder, Inc. All rights reserved.
 */
package com.topcoder.api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;

import com.topcoder.api.Utils;
import com.topcoder.api.entities.User;
import com.topcoder.api.entities.dtos.UserRequest;
import com.topcoder.api.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The service provides User related CRUD operations.
 * 
 * @author TCSCODER
 * @version 1.0
 */
@Service
@Transactional
public class UserService extends BaseService {
  /**
   * The user repository used to manage user data in the database.
   * It is injected by Spring, it should not be null.
   */
  @Autowired
  private UserRepository userRepository;

  /**
   * Check if all the configuration parameters are properly initialized.
   * 
   * @throws ConfigurationException if userRepository is not properly initialized.
   */
  @PostConstruct
  public void init() {
    Utils.checkNull(userRepository, "userRepository");
  }

  /**
   * Creates a User instance in the database using the handle specified in the given UserRequest.
   * 
   * @param request The UserRequest which contains the handle of the user to create.
   * @return The created User instance.
   */
  public User create(UserRequest request) {
    // Check if the user handle already exists
    User existingUser = userRepository.findByHandle(request.getHandle());
    if (existingUser != null) {
      throw new IllegalArgumentException(String.format("The user handle '%s' already exists", request.getHandle()));
    }

    User user = new User();
    user.setHandle(request.getHandle());

    return userRepository.save(user);
  }

  /**
   * Retrieved the list of all users from the database.
   * 
   * @return The List of all users in the database.
   */
  @Transactional(readOnly = true)
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  /**
   * Updates the user idenfied by the given userId with the handle in the specified request.
   * 
   * @param userId The id of the user to update.
   * @param request The UserRequest which holds the new handle of the user.
   * @return The updated User instance.
   */
  public User update(UUID userId, UserRequest request) {
    // Get the user by id.
    User user = getUserById(userId);

    // Check the specified handle already exists
    User userWithInputHandle = userRepository.findByHandle(request.getHandle());
    if(userWithInputHandle != null) {
      if(userWithInputHandle.getId().equals(user.getId())) {
        // nothing to update, return the user identified by the id
        return user;
      } else {
        // Another user with the same handle exists in the database, duplicate handles are not allowed.
        throw new IllegalArgumentException(String.format("The user handle '%s' already exists", request.getHandle()));
      }
    }

    // Update and save the user in the database
    user.setHandle(request.getHandle());
    return userRepository.save(user);
  }

  /**
   * Deletes the user identified by the given userId from the database.
   * 
   * @param userId The id of the user to delete.
   */
  public void delete(UUID userId) {
    // check if user exists
    getUserById(userId);

    // Delete the user
    userRepository.deleteById(userId);
  }

  /**
   * This private method gets a user by its id.
   * It throws EntityNotFoundException if the user is not found.
   * 
   * @param userId The id of the user to search for.
   * @return The User instance identified by the given id.
   */
  private User getUserById(UUID userId) {
    Optional<User> user = userRepository.findById(userId);

    if (!user.isPresent()) {
      throw new EntityNotFoundException(String.format("The user identified by id = %s does not exist", userId));
    }
    return user.get();
  }
}