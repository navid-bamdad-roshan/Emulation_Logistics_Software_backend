package com.example.els.springsecurity;
import java.util.ArrayList;
import com.example.els.user.UserService;
import com.example.els.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        try{
            User user = userService.getUserByUsername(username);
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
        }catch(Exception e){
            if (e.getMessage() == "multiple_users"){
                throw new UsernameNotFoundException("multiple_users");
            }
            else{
                throw new UsernameNotFoundException("user_not_found");
            }
        }
    }
}
