

package com.rrportafolio.portafolio.service;

import com.rrportafolio.portafolio.model.Portfolio;
import com.rrportafolio.portafolio.model.User;
import java.util.List;
import java.util.Optional;


public interface IPorfolioService {
    
    //Get all portfolios
    public List<Portfolio> getPortfolios();
    
    //Create a Portfolio
    public void savePortfolio(Portfolio portfolio);
    
    //Delete a Portfolio
    public void deletePortfolio(Long id);
    
    //Find Portfolio by id
    public Portfolio getOnePortfolioById(Long id);
    
    //Find Experienceby userId
    public Optional<List<Portfolio>> getPortfolioByUser(User user);
    
    //boolean, exists bu id
    public boolean existsById(Long id);

}
