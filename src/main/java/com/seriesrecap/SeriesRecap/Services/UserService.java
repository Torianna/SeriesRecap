package com.seriesrecap.SeriesRecap.Services;

import java.util.List;

import com.seriesrecap.SeriesRecap.Entites.User;

public interface UserService {

    User getUserById(int id);

    User deleteUserById(int id);

    User editUserById(int id, User user);

    User saveUser(User user);

    List<User> getAllUsers();
}
