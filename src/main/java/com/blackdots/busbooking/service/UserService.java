package com.blackdots.busbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackdots.busbooking.model.User;
import com.blackdots.busbooking.repository.SignUpJpaRepository;
@Service
public class UserService {
    @Autowired
    SignUpJpaRepository jpaRepository;
    
    public User registerUser(User form){
            return jpaRepository.save(form);

    }



}
