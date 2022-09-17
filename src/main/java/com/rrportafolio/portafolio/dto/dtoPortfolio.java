
package com.rrportafolio.portafolio.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class dtoPortfolio {
    
    @NotNull(message = "Must send a name")
    @NotBlank
    private String name;
    @NotNull(message = "Must send a description")
    @NotBlank
    private String description;
    @NotNull(message = "Must send a image")
    @NotBlank
    private String image;
    @NotNull(message = "Must send a url")
    @NotBlank
    private String url;
    @NotNull(message = "Must send a startDate")
    private Date startDate;
    @NotNull(message = "Must send a endDate")
    private Date endDate;
    @NotNull(message = "Must send an user id")
    private Long idUser;

    public dtoPortfolio() {
    }
    
    public dtoPortfolio(String name, String description, String image, String url, Date startDate, Date endDate, Long idUser) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.url = url;
        this.startDate = startDate;
        this.endDate = endDate;
        this.idUser = idUser;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    
    
    

}
