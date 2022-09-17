

package com.rrportafolio.portafolio.service;

import com.rrportafolio.portafolio.model.Profile;
import com.rrportafolio.portafolio.model.User;
import java.util.List;
import java.util.Optional;


public interface IProfileService {
    
    //Get all profiles
    public List<Profile> getProfiles();
    
    //Create a Profiles
    public void saveProfile(Profile profiles);
    
    //Delete a Profiles
    public void deleteProfile(Long id);
    
    //Find Profile by id
    public Profile getOneProfileById(Long id);
    
    //Find Experienceby userId
    public Optional<Profile> getProfileByUser(User user);
    
    //boolean, exists bu id
    public boolean existsById(Long id);
    
    //check if exists by email
    public boolean existsByEmail(String email);
    
    //Check if user has a profile
    public boolean existsByUser(User user);
    
}
