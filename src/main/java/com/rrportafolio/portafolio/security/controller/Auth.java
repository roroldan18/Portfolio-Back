
package com.rrportafolio.portafolio.security.controller;

import com.rrportafolio.portafolio.model.User;
import com.rrportafolio.portafolio.security.Message;
import com.rrportafolio.portafolio.security.dto.JwtDto;
import com.rrportafolio.portafolio.security.dto.LoginUser;
import com.rrportafolio.portafolio.security.dto.NewUser;
import com.rrportafolio.portafolio.security.entity.Rol;
import com.rrportafolio.portafolio.security.enums.RolName;
import com.rrportafolio.portafolio.security.jwt.JwtProvider;
import com.rrportafolio.portafolio.security.service.RolService;
import com.rrportafolio.portafolio.service.UserService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class Auth {
    
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/new")
    public ResponseEntity<?> newUser(@Valid @RequestBody NewUser userNew, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity(new Message("Bad or missing fields"), HttpStatus.BAD_REQUEST);
        }
        if(userService.existsByUsername(userNew.getUsername())){
            return new ResponseEntity(new Message("Username already exists"), HttpStatus.BAD_REQUEST);
        }
        
        User user = new User(userNew.getUsername(), passwordEncoder.encode(userNew.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolName(RolName.ROLE_USER).get());
        
        if(userNew.getRoles().contains("admin"))
            roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
        
        user.setRoles(roles);
        userService.saveUser(user);
        
        return new ResponseEntity(new Message("User saved!"), HttpStatus.CREATED);
        
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("Bad or missing fields"), HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        loginUser.getUsername(), loginUser.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto  = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
    
    

}
