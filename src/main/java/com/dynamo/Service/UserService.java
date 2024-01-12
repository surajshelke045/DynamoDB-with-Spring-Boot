package com.dynamo.Service;

import com.dynamo.Model.User;

import java.util.List;

public interface UserService {

    User SaveUser(User user);

    User getUserById(String userId);

    List<User> getAllUser();

    User updateUser(User user,String userId);

    User deleteUser(String userId);
}
