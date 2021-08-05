package com.example.casemd4teamwork.service.user;

import com.example.casemd4teamwork.model.User;
import com.example.casemd4teamwork.service.IGeneralService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByUserName(String username);

    Page<User> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
