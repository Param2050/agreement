package com.agreemenet.service;

import com.agreemenet.dto.UserDto;
import com.agreemenet.model.User;

public interface UserService {
    User createUser(UserDto userDto);
}
