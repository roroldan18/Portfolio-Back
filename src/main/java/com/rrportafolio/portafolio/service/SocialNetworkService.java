
package com.rrportafolio.portafolio.service;

import com.rrportafolio.portafolio.model.SocialNetwork;
import com.rrportafolio.portafolio.model.User;
import com.rrportafolio.portafolio.repository.SocialNetworkRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SocialNetworkService implements ISocialNetworkService {
    @Autowired
    private SocialNetworkRepository socialNetworkRepository;

    @Override
    public List<SocialNetwork> getSocialNetworks() {
        List<SocialNetwork> socialNetworks = socialNetworkRepository.findAll();
        return socialNetworks;
    }

    @Override
    public void saveSocialNetwork(SocialNetwork socialNetwork) {
        socialNetworkRepository.save(socialNetwork);
    }

    @Override
    public void deleteSocialNetwork(Long id) {
        socialNetworkRepository.deleteById(id);
    }

    @Override
    public SocialNetwork getOneSocialNetworkById(Long id) {
        SocialNetwork socialNetwork = socialNetworkRepository.findById(id).orElse(null);
        return socialNetwork;
    }

    @Override
    public Optional<List<SocialNetwork>> getSocialNetworkByUser(User user) {
        Optional<List<SocialNetwork>> socialNetworksByUser = socialNetworkRepository.findAllByUser(user);
        return socialNetworksByUser;
    }

    @Override
    public boolean existsById(Long id) {
        return socialNetworkRepository.existsById(id);
    }

    @Override
    public boolean existsByUrl(String url) {
        return socialNetworkRepository.existsByUrl(url);
    }
    
    

}
