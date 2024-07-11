package com.upc.tp_yapay.Services;

import com.upc.tp_yapay.Entities.User;
import com.upc.tp_yapay.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    //CRUD CUSTOMER
    public User save(User user){
        return userRepository.save(user);
    }

    public List<User> list(){
        return userRepository.findAll();
    }
}
