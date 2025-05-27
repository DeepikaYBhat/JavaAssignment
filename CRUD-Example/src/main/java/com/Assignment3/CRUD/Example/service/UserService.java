package com.Assignment3.CRUD.Example.service;

import com.Assignment3.CRUD.Example.entity.User;
import com.Assignment3.CRUD.Example.repository.UserRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

        @Autowired
        private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);

    }
    public User findById(int Id){
        Optional<User> user = userRepository.findById(Id);

        if(user.isEmpty()){
            throw  new RuntimeException("User not found");

        }
        return user.get();
    }

    public List<User> findAll(){
       return userRepository.findAll();
     }
     public User updateUser(User user) {
            Optional<User> dbuser = userRepository.findById(user.getEmpid());

            if (dbuser.isEmpty()) {
                throw new RuntimeException("User not found");
            }
                User existigUser = dbuser.get();
                existigUser.setEmpname(user.getEmpname());
                return userRepository.save(existigUser);

            }
    public void deleteUser(int id) {
        Optional<User> dbuser = userRepository.findById(id);
        if (dbuser.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        userRepository.delete(dbuser.get());
    }


}
