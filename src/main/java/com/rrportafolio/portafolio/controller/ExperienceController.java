
package com.rrportafolio.portafolio.controller;

import com.rrportafolio.portafolio.dto.dtoExperience;
import com.rrportafolio.portafolio.model.Experience;
import com.rrportafolio.portafolio.model.User;
import com.rrportafolio.portafolio.security.Message;
import com.rrportafolio.portafolio.service.ExperienceService;
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
@RequestMapping("/experience")
@CrossOrigin("https://portfolio-9d3d4.web.app")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;
    @Autowired
    private UserService userService;
    
    @GetMapping ("/")
    public List<Experience> getExperiences(){
        return experienceService.getExperiences();
    }
    
    //Get de toda la experience por id del usuario
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getExperienceByUSer(@PathVariable Long id){
        if(!userService.existsById(id)){
            return new ResponseEntity(new Message("The user does not exist"), HttpStatus.BAD_REQUEST);
        }
        User user = userService.getOneUserById(id);
        Optional<List<Experience>> experienceByUser =  experienceService.getExperienceByUser(user);
        return new ResponseEntity<Optional<List<Experience>>>(experienceByUser, HttpStatus.OK);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public ResponseEntity<?> postExperience(@Valid @RequestBody dtoExperience dtoExp){

        User user = userService.getOneUserById(dtoExp.getIdUser());
        
        Experience experience = new Experience(dtoExp.getCompany(), dtoExp.getTitle(), dtoExp.getDescription(), dtoExp.getTimeWork(), dtoExp.getStartDate(), dtoExp.getEndDate(), dtoExp.getLogo(), dtoExp.getIsActual(), user);
        experienceService.saveExperience(experience);
        
        return new ResponseEntity<>(experience, HttpStatus.CREATED);   
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> putExperience(@PathVariable("id") Long id, @RequestBody dtoExperience dtoExp){
        if(!experienceService.existsById(id)){
            return new ResponseEntity(new Message("ID does not exist"), HttpStatus.BAD_REQUEST);
        }
        
        Experience experience = experienceService.getOneExperienceById(id);
        experience.setTitle(dtoExp.getTitle());
        experience.setCompany(dtoExp.getCompany());
        experience.setIsActual(dtoExp.getIsActual());
        experience.setDescription(dtoExp.getDescription());
        experience.setEndDate(dtoExp.getEndDate());
        experience.setStartDate(dtoExp.getStartDate());
        experience.setLogo(dtoExp.getLogo());
        experience.setTimeWork(dtoExp.getTimeWork());
        
        
        experienceService.saveExperience(experience);
        
        return new ResponseEntity(new Message("Experience modified"), HttpStatus.OK);
        
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExperience(@PathVariable("id") Long id){
        if(!experienceService.existsById(id)){
                return new ResponseEntity(new Message("ID does not exist"), HttpStatus.BAD_REQUEST);
        }
        
        experienceService.deleteExperience(id);
        
        return new ResponseEntity(new Message("Experience deleted"), HttpStatus.OK);
        
    }
    
    
}
