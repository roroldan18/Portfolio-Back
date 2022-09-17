
package com.rrportafolio.portafolio.service;

import com.rrportafolio.portafolio.model.Education;
import com.rrportafolio.portafolio.model.User;
import com.rrportafolio.portafolio.repository.EducationRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@Transactional
public class EducationService implements IEducationService{
    
    @Autowired
    private EducationRepository educationRepository;
    
    

    @Override
    @ResponseBody
    public List<Education> getEducations() {
        List<Education> listEducations = educationRepository.findAll();
        return listEducations;
    }

    @Override
    public void saveEducation(Education education) {
        educationRepository.save(education);
    }

    @Override
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }

    @Override
    public Education getOneEducationById(Long id) {
        Education education = educationRepository.findById(id).orElse(null);
        return education;
    }

    @Override
    public Optional<List<Education>> getEducationByUser(User user) {
        Optional<List<Education>> listEducationByUser = educationRepository.findAllByUser(user);
        return listEducationByUser;
    }
    
    @Override
    public boolean existsById(Long id) {
        return educationRepository.existsById(id);
    }
    
    

}
