
package com.rrportafolio.portafolio.controller;

import com.rrportafolio.portafolio.dto.dtoSkill;
import com.rrportafolio.portafolio.model.Skill;
import com.rrportafolio.portafolio.model.User;
import com.rrportafolio.portafolio.security.Message;
import com.rrportafolio.portafolio.service.SkillService;
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
@RequestMapping("/skill")
@CrossOrigin("https://portfolio-9d3d4.web.app")
public class SkillController {
    @Autowired
    private UserService userService;
    @Autowired
    private SkillService skillService;
    
    @GetMapping("/")
    public List<Skill> getSkills(){
        List<Skill> skills = skillService.getSkills();
        return skills;
    }
    
    //Get skills por id del usuario
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getSkillsByUser(@PathVariable Long id){
        if(!userService.existsById(id)){
            return new ResponseEntity(new Message("The user does not exist"), HttpStatus.BAD_REQUEST);
        }
        User user = userService.getOneUserById(id);
        Optional<List<Skill>> skillByUser =  skillService.getSkillByUser(user);
        return new ResponseEntity<Optional<List<Skill>>>(skillByUser, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public ResponseEntity<?> postSkills(@Valid @RequestBody dtoSkill dtoS) {
        if(skillService.existsByName(dtoS.getName())){
            return new ResponseEntity(new Message("Ability already exists"), HttpStatus.BAD_REQUEST);
        }
        User user = userService.getOneUserById(dtoS.getIdUser());
        Skill skill = new Skill(dtoS.getName(), dtoS.getIcon(), dtoS.getAbilityPercentage(), user);        
        skillService.saveSkill(skill);
        
        return new ResponseEntity<>(skill, HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> putSkill(@PathVariable("id") Long id, @RequestBody dtoSkill dtoS){
        if(!skillService.existsById(id)){ 
            return new ResponseEntity(new Message("ID does not exist"), HttpStatus.BAD_REQUEST);
        }
        
        
        Skill skill = skillService.getOneSkillById(id);
        
        if(skillService.existsByName(dtoS.getName())){
            if(!skill.getName().equalsIgnoreCase(dtoS.getName())){
                return new ResponseEntity(new Message("Can't modify a name already exists"), HttpStatus.BAD_REQUEST);
            }
        }
        
        
        skill.setName(dtoS.getName());
        skill.setIcon(dtoS.getIcon());
        skill.setAbilityPercentage(dtoS.getAbilityPercentage());
        
        skillService.saveSkill(skill);
        
        return new ResponseEntity(new Message("Skill Edited"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable("id") Long id){
        if(!skillService.existsById(id)){ 
            return new ResponseEntity(new Message("ID does not exist"), HttpStatus.BAD_REQUEST);
        }
        skillService.deleteSkill(id);
        
        return new ResponseEntity(new Message("Skill Deleted"), HttpStatus.OK);
        
    }
    

}
