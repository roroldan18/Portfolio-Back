

package com.rrportafolio.portafolio.repository;

import com.rrportafolio.portafolio.model.Education;
import com.rrportafolio.portafolio.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long>{
    
    Optional<List<Education>> findAllByUser(User user);

}
