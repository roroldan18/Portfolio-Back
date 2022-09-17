

package com.rrportafolio.portafolio.service;

import com.rrportafolio.portafolio.model.Education;
import com.rrportafolio.portafolio.model.User;
import java.util.List;
import java.util.Optional;


public interface IEducationService {
    
    //Get all educations
    public List<Education> getEducations();
    
    //Create an education
    public void saveEducation(Education education);
    
    //Delete an education
    public void deleteEducation(Long id);
    
    //Find Education by id
    public Education getOneEducationById(Long id);
    
    //Find educations by userId
    public Optional<List<Education>> getEducationByUser(User user);
    
    //boolean, exists bu id
    public boolean existsById(Long id);

}
