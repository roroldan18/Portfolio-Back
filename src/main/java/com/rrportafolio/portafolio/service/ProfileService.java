
package com.rrportafolio.portafolio.service;

import com.rrportafolio.portafolio.model.Profile;
import com.rrportafolio.portafolio.model.User;
import com.rrportafolio.portafolio.repository.ProfileRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProfileService implements IProfileService{
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public List<Profile> getProfiles() {
        List<Profile> listProfiles = profileRepository.findAll();
        return listProfiles;
    }

    @Override
    public void saveProfile(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }

    @Override
    public Profile getOneProfileById(Long id) {
        Profile profile = profileRepository.findById(id).orElse(null);
        return profile;
    }

    @Override
    public Optional<Profile>  getProfileByUser(User user) {
        Optional<Profile> profile = profileRepository.findByUser(user);
        return profile;
    }

    @Override
    public boolean existsById(Long id) {
        return profileRepository.existsById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return profileRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByUser(User user) {
        return profileRepository.existsByUser(user);
    }
    
    
}
