package ru.app.userservice;

import ru.app.ui.model.request.UpdateUserDetailsRequestModel;
import ru.app.ui.model.request.UserDetailsRequestModel;
import ru.app.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);

    UserRest getUser(String userId);

    UserRest updateUser(String userId, UpdateUserDetailsRequestModel userDetails);

    void deleteUser(String userId);
}
