
package com.rrportafolio.portafolio.controller;

import com.rrportafolio.portafolio.dto.dtoSocialNetwork;
import com.rrportafolio.portafolio.model.SocialNetwork;
import com.rrportafolio.portafolio.model.User;
import com.rrportafolio.portafolio.security.Message;
import com.rrportafolio.portafolio.service.SocialNetworkService;
import com.rrportafolio.portafolio.service.UserService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socialnetwork")
@CrossOrigin("https://portfolio-9d3d4.web.app")
public class SocialNetworkController {
    @Autowired
    private UserService userService;
    @Autowired
    private SocialNetworkService socialNetworkService;
    
    
    @GetMapping("/")
    public List<SocialNetwork> getSocialNetworks(){
        List<SocialNetwork> socialNetworks = socialNetworkService.getSocialNetworks();
        return socialNetworks;
    }
    
    //Get skills por id del usuario
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getSocialNetworkByUser(@PathVariable Long id){
        if(!userService.existsById(id)){
            return new ResponseEntity(new Message("The user does not exist"), HttpStatus.BAD_REQUEST);
        }
        User user = userService.getOneUserById(id);
        Optional<List<SocialNetwork>> snByUser =  socialNetworkService.getSocialNetworkByUser(user);
        return new ResponseEntity<Optional<List<SocialNetwork>>>(snByUser, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public ResponseEntity<?> postSocialNetwork(@Valid @RequestBody dtoSocialNetwork dtoSN){
        User user = userService.getOneUserById(dtoSN.getIdUser());
        SocialNetwork newSocialNetwork = new SocialNetwork(
                dtoSN.getUrl(), 
                dtoSN.getIcon(), 
                dtoSN.isDownloadable(), 
                user,
                dtoSN.getName()
        );
        
        socialNetworkService.saveSocialNetwork(newSocialNetwork);
        return new ResponseEntity<>(newSocialNetwork, HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> putSocialNetwork(@PathVariable("id") Long id, @RequestBody dtoSocialNetwork dtoSN){
        if(!socialNetworkService.existsById(id)){
            return new ResponseEntity(new Message("Id does not exists"), HttpStatus.BAD_REQUEST);
        }
        
        SocialNetwork socialNetwork = socialNetworkService.getOneSocialNetworkById(id);
        
        socialNetwork.setIcon(dtoSN.getIcon());
        socialNetwork.setUrl(dtoSN.getUrl());
        socialNetwork.setDownloadable(dtoSN.isDownloadable());
        socialNetwork.setName(dtoSN.getName());
        
        socialNetworkService.saveSocialNetwork(socialNetwork);
        
        return new ResponseEntity(new Message("social network edited!"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSocialNetwork(@PathVariable("id") Long id){
        if(!socialNetworkService.existsById(id)){
            return new ResponseEntity(new Message("Id does not exists"), HttpStatus.BAD_REQUEST);
        }
     
        socialNetworkService.deleteSocialNetwork(id);
        
        return new ResponseEntity(new Message("social network deleted!"), HttpStatus.OK);
    }
    

}
