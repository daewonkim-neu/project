package com.example.INFO5100FinalProject.repository;

import com.example.INFO5100FinalProject.dao.UserDao;
import com.example.INFO5100FinalProject.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository implements UserDao {
    private static List<User> userDB = new ArrayList<>();
//    userDB.add(new User(UUID.randomUUID()))

    @Override
    public int insertUser(UUID id, User user) {
        userDB.add(new User(id, user.getName(), user.getUserName(), user.getPassword(), user.getEmail()));
        return 1;
    }

    @Override
    public List<User> selectAllUsers() {
        return userDB;
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return userDB.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public int updateUserById(UUID id, User userUpdateRequest) {
        return selectUserById(id)
                .map(usr -> {
                    int idxToUpdate = userDB.indexOf(usr);
                    if (idxToUpdate >= 0) {
                        userDB.set(idxToUpdate, new User(id, userUpdateRequest.getName(), userUpdateRequest.getUserName(), userUpdateRequest.getPassword(), userUpdateRequest.getEmail()));
                        return 1;
                }
                return 0;
            })
            .orElse(0);
    }

    @Override
    public int deleteUserById(UUID id) {
        Optional<User> user = selectUserById(id);
        if (user.isEmpty()) return 0;
        userDB.remove(user.get());

        return 1;
    }
}
