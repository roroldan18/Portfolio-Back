package com.rrportafolio.portafolio.repository;

import com.rrportafolio.portafolio.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//El repository al extender de JpaRepository lo que hace es implementar todos los metodos para trabajar con la BD (findall, delete, save, etc.)
public interface UserRepository extends JpaRepository<User, Long>{
    
    Optional<User> findByUsername(String username);
    
    boolean existsByUsername(String username);
    boolean existsById(Long id);

}
