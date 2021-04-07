package com.example.els.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User getUserById(Long id) {
        try{
            User user = userRepository.findById(id).get();
            return user;
        } catch(Exception e){
            throw e;
        }
    }

    public User getUserByUsername(String username) throws Exception {
        try{
            List<User> userList = userRepository.findByUsername(username);
            // username field is unique in database
            if (userList.size() > 1){
                throw new Exception("multiple_users");
            }else{
                return userList.get(0);
            }
        } catch(Exception e){
            throw e;
        }
    }

    public User addNewUser(User user){
        userRepository.save(user);
        return user;
    }


    
}
