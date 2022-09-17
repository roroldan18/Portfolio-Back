

package com.rrportafolio.portafolio.repository;

import com.rrportafolio.portafolio.model.Experience;
import com.rrportafolio.portafolio.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    
    Optional<List<Experience>> findAllByUser(User user);

}
