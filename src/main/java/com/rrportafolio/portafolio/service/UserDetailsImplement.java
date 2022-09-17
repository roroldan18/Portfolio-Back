
package com.rrportafolio.portafolio.service;

import com.rrportafolio.portafolio.model.PrincipalUser;
import com.rrportafolio.portafolio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsImplement implements UserDetailsService{
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getOneUserByUsername(username).get();
        return PrincipalUser.build(user);
    }
    
    
    

}
