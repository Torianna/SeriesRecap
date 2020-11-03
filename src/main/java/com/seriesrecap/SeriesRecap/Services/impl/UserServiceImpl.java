package com.seriesrecap.SeriesRecap.Services.impl;
import com.seriesrecap.SeriesRecap.Entites.User;
import com.seriesrecap.SeriesRecap.Repositories.UserRepository;
import com.seriesrecap.SeriesRecap.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;
	
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User deleteUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return user.get();
        }
        return null;
    }

    @Override
    public User editUserById(int id, User userCommand) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return new User(userRepository.save(userCommand).getId(), userCommand.getUserName(),
                    userCommand.getPassword()); //, userCommand.getSeries());
        }
        return null;
    }

    @Override
    public User saveUser(User user) {
//    	System.out.println("series "+user.getSeries());
        userRepository.save(user);
        return new User(user.getId(), user.getUserName(), user.getPassword()); //, user.getSeries());
    }
    
    @Override
    public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
}
