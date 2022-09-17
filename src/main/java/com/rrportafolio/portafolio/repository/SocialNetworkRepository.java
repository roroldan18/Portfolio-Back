

package com.rrportafolio.portafolio.repository;

import com.rrportafolio.portafolio.model.User;
import com.rrportafolio.portafolio.model.SocialNetwork;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SocialNetworkRepository extends JpaRepository<SocialNetwork, Long>{
    Optional<List<SocialNetwork>> findAllByUser(User user);
    boolean existsByUrl(String url);
}
