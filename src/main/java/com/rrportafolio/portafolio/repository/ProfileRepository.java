

package com.rrportafolio.portafolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rrportafolio.portafolio.model.Profile;
import com.rrportafolio.portafolio.model.User;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>{
    Optional<Profile> findByUser(User user);
    boolean existsByEmail(String email);
    boolean existsByUser(User user);
}
