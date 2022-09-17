
package com.rrportafolio.portafolio.controller;

import com.rrportafolio.portafolio.dto.dtoEducation;
import com.rrportafolio.portafolio.model.Education;
import com.rrportafolio.portafolio.model.User;
import com.rrportafolio.portafolio.security.Message;
import com.rrportafolio.portafolio.service.EducationService;
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
@RequestMapping("/education")
@CrossOrigin("https://portfolio-9d3d4.web.app")
public class EducationController {
    @Autowired
    private EducationService educationService;
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public List<Education> getEducations(){
        return educationService.getEducations();
    }
    
    //Get de toda la educacion por id del usuario
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getEducationByUser(@PathVariable Long id){
        if(!userService.existsById(id)){
            return new ResponseEntity(new Message("The user does not exist"), HttpStatus.BAD_REQUEST);
        }
        User user = userService.getOneUserById(id);
        Optional<List<Education>> educationByUser =  educationService.getEducationByUser(user);
        return new ResponseEntity<Optional<List<Education>>>(educationByUser, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public ResponseEntity<?> postEducation(@Valid @RequestBody dtoEducation dtoEdu){
        User user = userService.getOneUserById(dtoEdu.getIdUser());
        
        Education education = new Education(dtoEdu.getCareerTitle(), dtoEdu.getEducationalEstablishment(), dtoEdu.getImage(), dtoEdu.getStartDate(), dtoEdu.getEndDate(), dtoEdu.isIsActual(), user);
        educationService.saveEducation(education);
        
        return new ResponseEntity<>(education, HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> putEducation(@PathVariable("id") Long id, @RequestBody dtoEducation dtoEdu){
        if(!educationService.existsById(id)){
            return new ResponseEntity(new Message("ID does not exist"), HttpStatus.BAD_REQUEST);
        }
        Education education = educationService.getOneEducationById(id);
        education.setIsActual(dtoEdu.isIsActual());
        education.setCareerTitle(dtoEdu.getCareerTitle());
        education.setEducationalEstablishment(dtoEdu.getEducationalEstablishment());
        education.setStartDate(dtoEdu.getStartDate());
        education.setEndDate(dtoEdu.getEndDate());
        education.setImage(dtoEdu.getImage());
        
        educationService.saveEducation(education);
        
        return new ResponseEntity(new Message("Education edited"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEducation(@PathVariable("id") Long id){
        if(!educationService.existsById(id)){
            return new ResponseEntity(new Message("ID does not exist"), HttpStatus.BAD_REQUEST);
        }
        
        educationService.deleteEducation(id);
        return new ResponseEntity(new Message("Education deleted"), HttpStatus.OK);
    }

}
