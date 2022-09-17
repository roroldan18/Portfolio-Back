
package com.rrportafolio.portafolio.controller;

import com.rrportafolio.portafolio.dto.dtoProfile;
import com.rrportafolio.portafolio.model.Profile;
import com.rrportafolio.portafolio.model.User;
import com.rrportafolio.portafolio.security.Message;
import com.rrportafolio.portafolio.service.ProfileService;
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
@RequestMapping("/profile")
@CrossOrigin("https://portfolio-9d3d4.web.app")
public class ProfileController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProfileService profileService;
    
    
    @GetMapping("/")
    public List<Profile> getProfiles(){
        List<Profile> profiles =  profileService.getProfiles();
        return profiles;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getProfileById(@PathVariable Long id){
        if(!userService.existsById(id)){
            return new ResponseEntity(new Message("The user does not exist"), HttpStatus.BAD_REQUEST);
        }
        Profile profile =  profileService.getOneProfileById(id);
        
        return new ResponseEntity<Profile>(profile, HttpStatus.OK);
    }
    
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getProfileByUser(@PathVariable Long id){
        if(!userService.existsById(id)){
            return new ResponseEntity(new Message("The user does not exist"), HttpStatus.BAD_REQUEST);
        }
        User user = userService.getOneUserById(id);
        Optional<Profile> profileByUser =  profileService.getProfileByUser(user);
        return new ResponseEntity<Optional<Profile>>(profileByUser, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public ResponseEntity<?> postProfile(@Valid @RequestBody dtoProfile dtoP){
        if(profileService.existsByEmail(dtoP.getEmail())){
            return new ResponseEntity(new Message("Email already exists"), HttpStatus.BAD_REQUEST);
        }
        
        User user = userService.getOneUserById(dtoP.getIdUser());
        
        //check if the user already has a profile
        if(profileService.existsByUser(user)){
            return new ResponseEntity(new Message("The User already has a profile, you should edit it"), HttpStatus.BAD_REQUEST);
        }
        
        
        Profile profile = new Profile(
                dtoP.getBannerImage(), 
                dtoP.getProfileImage(), 
                dtoP.getName(), 
                dtoP.getLastName(), 
                dtoP.getTitle(), 
                dtoP.getProvince(), 
                dtoP.getCountry(), 
                dtoP.getTelephone(), 
                dtoP.getEmail(), 
                dtoP.getAboutMe(), 
                dtoP.getLogo(), 
                user);
        profileService.saveProfile(profile);    
        return new ResponseEntity<>(profile, HttpStatus.CREATED);   
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> putProfile(@PathVariable("id") Long id, @RequestBody dtoProfile dtoP){
        if(!profileService.existsById(id)){
            return new ResponseEntity(new Message("Id does not exists"), HttpStatus.BAD_REQUEST);
        }
        
        Profile profile = profileService.getOneProfileById(id);
        
        
        if(profileService.existsByEmail(dtoP.getEmail())){
            if(!dtoP.getEmail().equalsIgnoreCase(profile.getEmail())){
             return new ResponseEntity(new Message("This email is used by other person"), HttpStatus.BAD_REQUEST);   
            }
        }
        
        profile.setBannerImage(dtoP.getBannerImage());
        profile.setProfileImage(dtoP.getProfileImage());
        profile.setName(dtoP.getName());
        profile.setLastName(dtoP.getLastName());
        profile.setTitle(dtoP.getTitle());
        profile.setProvince(dtoP.getProvince());
        profile.setCountry(dtoP.getCountry());
        profile.setTelephone(dtoP.getTelephone());
        profile.setEmail(dtoP.getEmail());
        profile.setAboutMe(dtoP.getAboutMe());
        profile.setLogo(dtoP.getLogo());
        
        profileService.saveProfile(profile);    
        
        return new ResponseEntity(new Message("Profile edited!"), HttpStatus.CREATED);   
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfile(@PathVariable("id") Long id){
        if(!profileService.existsById(id)){
            return new ResponseEntity(new Message("Id does not exists"), HttpStatus.BAD_REQUEST);
        }
        
        profileService.deleteProfile(id);
        
        return new ResponseEntity(new Message("Profile deleted"), HttpStatus.OK);
    }
    
    
    
    
}
