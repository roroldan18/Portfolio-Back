
package com.rrportafolio.portafolio.controller;

import com.rrportafolio.portafolio.dto.dtoPortfolio;
import com.rrportafolio.portafolio.model.Portfolio;
import com.rrportafolio.portafolio.model.User;
import com.rrportafolio.portafolio.security.Message;
import com.rrportafolio.portafolio.service.PortfolioService;
import com.rrportafolio.portafolio.service.UserService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio")
@CrossOrigin("*")
public class PortfolioController {
    @Autowired
    private PortfolioService portfolioService;
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public List<Portfolio> getPortfolios(){
        List<Portfolio> portfolios = portfolioService.getPortfolios();
        return portfolios;
    }
    
    //Get de toda la experience por id del usuario
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getPortfolioByUSer(@PathVariable Long id){
        if(!userService.existsById(id)){
            return new ResponseEntity(new Message("The user does not exist"), HttpStatus.BAD_REQUEST);
        }
        User user = userService.getOneUserById(id);
        Optional<List<Portfolio>> portfolioByUser =  portfolioService.getPortfolioByUser(user);
        return new ResponseEntity<Optional<List<Portfolio>>>(portfolioByUser, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public ResponseEntity<?> postPortfolio(@Valid @RequestBody dtoPortfolio dtoPort){
        User user = userService.getOneUserById(dtoPort.getIdUser());
        
        Portfolio portfolio = new Portfolio(dtoPort.getName(), dtoPort.getDescription(), dtoPort.getImage(), dtoPort.getUrl(), dtoPort.getStartDate(), dtoPort.getEndDate(), user);
        
        portfolioService.savePortfolio(portfolio);
        
        return new ResponseEntity<>(portfolio, HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<?> putPortfolio(@PathVariable("id") Long id, @RequestBody dtoPortfolio dtoPort){
        
        if(!portfolioService.existsById(id)){ 
            return new ResponseEntity(new Message("ID does not exist"), HttpStatus.BAD_REQUEST);
        }
        
        Portfolio portfolio = portfolioService.getOnePortfolioById(id);
        
        portfolio.setDescription(dtoPort.getDescription());
        portfolio.setImage(dtoPort.getImage());
        portfolio.setName(dtoPort.getName());
        portfolio.setUrl(dtoPort.getUrl());
        portfolio.setStartDate(dtoPort.getStartDate());
        portfolio.setEndDate(dtoPort.getEndDate());
        
        portfolioService.savePortfolio(portfolio);
        
        return new ResponseEntity(new Message("Portfolio Edited"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePortfolio(@PathVariable("id") Long id){
        if(!portfolioService.existsById(id)){
            return new ResponseEntity(new Message("ID does not exist"), HttpStatus.BAD_REQUEST);
        }
        
        portfolioService.deletePortfolio(id);
       
        return new ResponseEntity(new Message("Portfolio deleted"), HttpStatus.OK);
        
    }
    

}
