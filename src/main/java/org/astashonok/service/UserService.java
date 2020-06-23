package org.astashonok.service;

import org.astashonok.exception.EntityNotFoundException;
import org.astashonok.model.User;

import java.util.List;

public interface UserService {
    User add(User user);
    void delete(long id);
    User getById(long id) throws EntityNotFoundException;
    User edit(User user);
    List<User> getAll();
    List<User> getRichestUsers();
}
