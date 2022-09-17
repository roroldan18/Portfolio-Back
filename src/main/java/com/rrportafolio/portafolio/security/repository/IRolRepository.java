

package com.rrportafolio.portafolio.security.repository;

import com.rrportafolio.portafolio.security.entity.Rol;
import com.rrportafolio.portafolio.security.enums.RolName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long>{
    Optional<Rol> findByRolName(RolName rolName);

}
