
package com.rrportafolio.portafolio.service;

import java.util.List;
import com.rrportafolio.portafolio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rrportafolio.portafolio.repository.UserRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@Transactional
public class UserService implements IUserService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    @ResponseBody
    public List<User> getUsers() {
        List<User> listUser = userRepository.findAll();
        return listUser;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getOneUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    @Override
    public Optional<User> getOneUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }
}
