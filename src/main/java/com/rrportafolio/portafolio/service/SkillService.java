
package com.rrportafolio.portafolio.service;

import com.rrportafolio.portafolio.model.Skill;
import com.rrportafolio.portafolio.model.User;
import com.rrportafolio.portafolio.repository.SkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class SkillService implements ISkillService{
    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<Skill> getSkills() {
        List<Skill> listSkills = skillRepository.findAll();
        return listSkills;
    }

    @Override
    public void saveSkill(Skill skill) {
        skillRepository.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public Skill getOneSkillById(Long id) {
        Skill skill = skillRepository.findById(id).orElse(null);
        return skill;
    }

    @Override
    public Optional<List<Skill>> getSkillByUser(User user) {
        Optional<List<Skill>> skillsByUser = skillRepository.findAllByUser(user);
        return skillsByUser;
    }

    @Override
    public boolean existsById(Long id) {
        return skillRepository.existsById(id);
    }
    
    @Override
    public boolean existsByName(String name) {
        return skillRepository.existsByName(name);

    }
    
    
}
