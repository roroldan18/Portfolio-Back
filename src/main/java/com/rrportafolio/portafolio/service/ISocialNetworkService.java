

package com.rrportafolio.portafolio.service;

import com.rrportafolio.portafolio.model.SocialNetwork;
import com.rrportafolio.portafolio.model.User;
import java.util.List;
import java.util.Optional;


public interface ISocialNetworkService {
    //Get all Social Networks
    public List<SocialNetwork> getSocialNetworks();
    
    //Create a Social Network
    public void saveSocialNetwork(SocialNetwork socialNetwork);
    
    //Delete a SocialNetwork
    public void deleteSocialNetwork(Long id);
    
    //Find SocialNetwork by id
    public SocialNetwork getOneSocialNetworkById(Long id);
    
    //Find Experienceby userId
    public Optional<List<SocialNetwork>> getSocialNetworkByUser(User user);
    
    //boolean, exists bu id
    public boolean existsById(Long id);
    
    public boolean existsByUrl(String url);

}
