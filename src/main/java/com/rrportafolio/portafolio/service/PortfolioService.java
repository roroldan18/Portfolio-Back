
package com.rrportafolio.portafolio.service;

import com.rrportafolio.portafolio.model.Portfolio;
import com.rrportafolio.portafolio.model.User;
import com.rrportafolio.portafolio.repository.PortfolioRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PortfolioService implements IPorfolioService {
    
    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    public List<Portfolio> getPortfolios() {
        List<Portfolio> listPortfolios = portfolioRepository.findAll();
        return listPortfolios;
    }

    @Override
    public void savePortfolio(Portfolio portfolio) {
        portfolioRepository.save(portfolio);
    }

    @Override
    public void deletePortfolio(Long id) {
        portfolioRepository.deleteById(id);
    }

    @Override
    public Portfolio getOnePortfolioById(Long id) {
        Portfolio portfolio = portfolioRepository.findById(id).orElse(null);
        return portfolio;
    }

    @Override
    public Optional<List<Portfolio>> getPortfolioByUser(User user) {
        Optional<List<Portfolio>> listPortfolioByUser = portfolioRepository.findAllByUser(user);
        return listPortfolioByUser;
    }

    @Override
    public boolean existsById(Long id) {
        return portfolioRepository.existsById(id);
    }
    
    

}
