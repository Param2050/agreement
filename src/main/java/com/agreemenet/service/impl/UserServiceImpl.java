package com.agreemenet.service.impl;

import com.agreemenet.dto.UserDto;
import com.agreemenet.exceptions.ValidationException;
import com.agreemenet.model.User;
import com.agreemenet.repository.UserRepository;
import com.agreemenet.service.UserService;
import com.agreemenet.utils.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(UserDto userDto) {
        validateRequest(userDto);
        String userId = userDto.getName() + "_" + UUID.randomUUID();
        User user = new User(userId, userDto.getName(), userDto.getMobile(), userDto.getEmailId());
        return userRepository.save(user);
    }

    private void validateRequest(UserDto userDto) {
        ExceptionUtil.validateNotEmpty(userDto.getName(), "Username can not be empty");
        ExceptionUtil.validateNotEmpty(userDto.getMobile(), "Mobile no. can not empty");
        Optional<User> user = userRepository.findByUsernameAndMobile(userDto.getName(), userDto.getMobile());
        if(user.isPresent()) {
            throw new ValidationException("User is already present");
        }
    }


}
