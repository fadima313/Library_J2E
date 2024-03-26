package com.librarydomain.Repositories;

import com.librarydomain.Dto.UserDto;
import com.librarydomain.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}