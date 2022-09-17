
package com.rrportafolio.portafolio.security.service;

import com.rrportafolio.portafolio.security.entity.Rol;
import com.rrportafolio.portafolio.security.enums.RolName;
import com.rrportafolio.portafolio.security.repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// El transactional trata de mantener lo mismo que tenemos con la base de datos.
// Es decir, operar mediante transacciones (de forma de poder hacer rollback);
@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository iRolRepository;
    
    public Optional<Rol> getByRolName(RolName rolName){
        return iRolRepository.findByRolName(rolName);
    }
    
    public void save(Rol rol){
        iRolRepository.save(rol);
    }

}
