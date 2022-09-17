package com.rrportafolio.portafolio.controller;
import com.rrportafolio.portafolio.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rrportafolio.portafolio.service.IUserService;
import java.util.List;
import java.util.Optional;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController 
@RequestMapping("/users")
@CrossOrigin("https://portfolio-9d3d4.web.app")
public class UserController {
    @Autowired
    private IUserService interUserService;

        
    @GetMapping ("/")
    public List<User> getUsers(){
        return interUserService.getUsers();
    }
    
    @GetMapping("/username/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username){
        return interUserService.getOneUserByUsername(username);
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/{id}")
    public String deleteUser(@PathVariable Long id){
        interUserService.deleteUser(id);
        return "User deleted";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/{id}")
    public User editUser(
            @PathVariable Long id,
            @RequestBody String username,
            @RequestBody String password){
        User user = interUserService.getOneUserById(id);
        
        user.setUsername(username);
        user.setPassword(password);
        
        interUserService.saveUser(user);
        
        return user;
    }
    
    

}
