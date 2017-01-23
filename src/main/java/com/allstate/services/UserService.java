package com.allstate.services;

import com.allstate.entities.User;
import com.allstate.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    private IUserRepository userRepository;

    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(String email){
        return this.userRepository.save(new User(email));
    }

    public Iterable<User> findAll(){
        return this.userRepository.findAll();
    }

    public User findUserById(int id){
        Optional<User> oUser = Optional.ofNullable(this.userRepository.findOne(id));
        if(oUser.isPresent()) {
            return oUser.get();
        }else{
            throw new IllegalArgumentException("User ID is not found");
        }
    }

}
