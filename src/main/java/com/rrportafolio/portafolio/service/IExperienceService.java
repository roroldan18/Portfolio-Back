

package com.rrportafolio.portafolio.service;

import com.rrportafolio.portafolio.model.Experience;
import com.rrportafolio.portafolio.model.User;
import java.util.List;
import java.util.Optional;


public interface IExperienceService {
    
    //Get all experiences
    public List<Experience> getExperiences();
    
    //Create an experience
    public void saveExperience(Experience experience);
    
    //Delete an experience
    public void deleteExperience(Long id);
    
    //Find Experience by id
    public Experience getOneExperienceById(Long id);
    
    //Find Experienceby userId
    public Optional<List<Experience>> getExperienceByUser(User user);
    
    //Check if experience exists
    public boolean existsById(Long id);

}
