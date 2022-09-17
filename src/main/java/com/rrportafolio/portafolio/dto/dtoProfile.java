
package com.rrportafolio.portafolio.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class dtoProfile {
    
    @NotNull(message = "Must send a bannerImage")
    @NotBlank(message = "Must send a bannerImage")
    private String bannerImage;
    @NotNull(message = "Must send a profileImage")
    @NotBlank(message = "Must send a profileImage")
    private String profileImage;
    @NotNull(message = "Must send a name")
    @NotBlank(message = "Must send a name")
    private String name;
    @NotNull(message = "Must send a lastName")
    @NotBlank(message = "Must send a lastName")
    private String lastName;
    @NotNull(message = "Must send a title")
    @NotBlank(message = "Must send a title")
    private String title;
    @NotNull(message = "Must send a province")
    @NotBlank(message = "Must send a province")
    private String province;
    @NotNull(message = "Must send a country")
    @NotBlank(message = "Must send a country")
    private String country;
    @NotNull(message = "Must send a telephone")
    @NotBlank(message = "Must send a telephone")
    private String telephone;
    @NotNull(message = "Must send a email")
    @NotBlank(message = "Must send a email")
    private String email;
    @NotNull(message = "Must send a aboutMe")
    @NotBlank(message = "Must send a aboutMe")
    private String aboutMe;
    @NotNull(message = "Must send a logo")
    @NotBlank(message = "Must send a logo")
    private String logo;
    @NotNull(message = "Must send an user id")
    private Long idUser;

    public dtoProfile() {
    }

    public dtoProfile(String bannerImage, String profileImage, String name, String lastName, String title, String province, String country, String telephone, String email, String aboutMe, String logo, Long idUser) {
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
        this.idUser = idUser;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    
    
    
    
    

}
