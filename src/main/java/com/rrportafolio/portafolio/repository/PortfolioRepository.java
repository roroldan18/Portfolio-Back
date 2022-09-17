

package com.rrportafolio.portafolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rrportafolio.portafolio.model.Portfolio;
import com.rrportafolio.portafolio.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;


@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long>{
    
    Optional<List<Portfolio>> findAllByUser(User user);

}
