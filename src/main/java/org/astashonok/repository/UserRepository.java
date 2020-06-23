package org.astashonok.repository;

import org.astashonok.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u JOIN Account a ON u.userId = a.userId WHERE a.account = (SELECT MAX(a.account) FROM Account a)")
    List<User> getRichestUsers();
}
