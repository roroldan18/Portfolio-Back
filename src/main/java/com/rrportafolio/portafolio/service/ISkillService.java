

package com.rrportafolio.portafolio.service;

import com.rrportafolio.portafolio.model.Skill;
import com.rrportafolio.portafolio.model.User;
import java.util.List;
import java.util.Optional;


public interface ISkillService {
    
    //Get all skills
    public List<Skill> getSkills();
    
    //Create a Skill
    public void saveSkill(Skill skill);
    
    //Delete a Skill
    public void deleteSkill(Long id);
    
    //Find Skill by id
    public Skill getOneSkillById(Long id);
    
    //Find Experienceby userId
    public Optional<List<Skill>> getSkillByUser(User user);
    
    //boolean, exists bu id
    public boolean existsById(Long id);
    
    //boolean, exists bu id
    public boolean existsByName(String name);


}
