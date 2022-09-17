
package com.rrportafolio.portafolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name="banner_image")
    private String bannerImage;
    @NotNull
    @Column(name="profile_image")
    private String profileImage;
    @NotNull
    private String name;
    @NotNull
    @Column(name="last_name")
    private String lastName;
    @NotNull
    private String title;
    @NotNull
    private String province;
    @NotNull
    private String country;
    @NotNull
    private String telephone;
    @NotNull
    @Column(unique=true)
    private String email;
    @NotNull
    @Column(name="about_me")
    private String aboutMe;
    @NotNull
    private String logo;
    
    @NotNull
    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Profile() {
    }

    public Profile(String bannerImage, String profileImage, String name, String lastName, String title, String province, String country, String telephone, String email, String aboutMe, String logo, User user) {
        this.bannerImage = bannerImage;
        this.profileImage = profileImage;
        this.name = name;
        this.lastName = lastName;
        this.title = title;
        this.province = province;
        this.country = country;
        this.telephone = telephone;
        this.email = email;
        this.aboutMe = aboutMe;
        this.logo = logo;
        this.user = user;
    }
    
    
    
    
}
