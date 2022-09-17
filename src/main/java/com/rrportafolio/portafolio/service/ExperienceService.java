
package com.rrportafolio.portafolio.service;

import com.rrportafolio.portafolio.model.Experience;
import com.rrportafolio.portafolio.model.User;
import com.rrportafolio.portafolio.repository.ExperienceRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@Transactional
public class ExperienceService implements IExperienceService{
    
    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    @ResponseBody
    public List<Experience> getExperiences() {
        List<Experience> listEducations = experienceRepository.findAll();
        return listEducations;
    }

    @Override
    public void saveExperience(Experience experience) {
        experienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }

    @Override
    public Experience getOneExperienceById(Long id) {
        Experience experience = experienceRepository.findById(id).orElse(null);
        return experience;
    }

    @Override
    public Optional<List<Experience>> getExperienceByUser(User user) {
        Optional<List<Experience>> listExperienceByUser = experienceRepository.findAllByUser(user);
        return listExperienceByUser;
    }

    @Override
    public boolean existsById(Long id) {
        return experienceRepository.existsById(id);
    }
    

}
