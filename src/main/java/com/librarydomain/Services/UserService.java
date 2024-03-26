package com.librarydomain.Services;

import com.librarydomain.Entities.User;
import org.springframework.stereotype.Service;
import com.librarydomain.Dto.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}