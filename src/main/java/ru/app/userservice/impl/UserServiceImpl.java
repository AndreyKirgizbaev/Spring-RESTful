package ru.app.userservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.app.shared.Utils;
import ru.app.ui.model.request.UpdateUserDetailsRequestModel;
import ru.app.ui.model.request.UserDetailsRequestModel;
import ru.app.ui.model.response.UserRest;
import ru.app.userservice.UserService;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private Map<String, UserRest> users = new HashMap<>();
    private Utils utils;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {

        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());

        String userId = utils.generateUserId();
        returnValue.setUserId(userId);

        if (users == null) users = new HashMap<>();
        users.put(userId, returnValue);

        return returnValue;
    }

    @Override
    public UserRest getUser(String userId) {
        return users.getOrDefault(userId, null);
    }

    @Override
    public UserRest updateUser(String userId, UpdateUserDetailsRequestModel userDetails){
        UserRest userRest = users.get(userId);

        userRest.setFirstName(userDetails.getFirstName());
        userRest.setLastName(userDetails.getLastName());

        users.put(userId, userRest);

        return userRest;
    }

    @Override
    public void deleteUser(String userId){
        users.remove(userId);
    }
}
