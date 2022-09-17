

package com.rrportafolio.portafolio.repository;

import com.rrportafolio.portafolio.model.User;
import com.rrportafolio.portafolio.model.Skill;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    Optional<List<Skill>> findAllByUser(User user);
    boolean existsByName(String name);
}
