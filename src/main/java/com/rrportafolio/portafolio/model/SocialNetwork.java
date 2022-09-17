
package com.rrportafolio.portafolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="social_network")
public class SocialNetwork {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique=true)
    private String url;
    @NotNull
    private String icon;
    @NotNull
    private String name;
    @NotNull
    private boolean downloadable;
    
    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public SocialNetwork() {
    }

    public SocialNetwork(String url, String icon, boolean downloadable, User user, String name) {
        this.url = url;
        this.icon = icon;
        this.downloadable = downloadable;
        this.user = user;
        this.name = name;
    }
    

}
