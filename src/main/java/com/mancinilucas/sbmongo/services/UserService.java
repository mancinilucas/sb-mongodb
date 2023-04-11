package com.mancinilucas.sbmongo.services;

import com.mancinilucas.sbmongo.domain.User;
import com.mancinilucas.sbmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
