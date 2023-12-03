package com.example.INFO5100FinalProject.dao;

import com.example.INFO5100FinalProject.model.User;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

public interface UserDao {

    int insertUser(UUID id, User user);

    default int insertUser(User user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    List<User> selectAllUsers();

    Optional<User> selectUserById(UUID id);

    int updateUserById(UUID id, User user);

    int deleteUserById(UUID id);
}
