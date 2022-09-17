
package com.rrportafolio.portafolio.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class dtoEducation {
    
    @NotNull(message = "Must send a careerTitle")
    @NotBlank(message = "Must send a careerTitle")
    private String careerTitle;
    @NotNull(message = "Must send a title")
    @NotBlank(message = "Must send a title")
    private String educationalEstablishment;    
    private String image;
    @NotNull(message = "Must send a startDate")
    private Date startDate;
    private Date endDate;
    @NotNull(message = "Must send a isActual")
    private boolean isActual;
    @NotNull(message = "Must send an user id")
    private Long idUser;
    
    
    public dtoEducation() {
        
    }

    public dtoEducation(String careerTitle, String educationalEstablishment, String image, Date startDate, Date endDate, boolean isActual, Long idUser) {
        this.careerTitle = careerTitle;
        this.educationalEstablishment = educationalEstablishment;
        this.image = image;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActual = isActual;
        this.idUser = idUser;
    }

    public String getCareerTitle() {
        return careerTitle;
    }

    public void setCareerTitle(String careerTitle) {
        this.careerTitle = careerTitle;
    }

    public String getEducationalEstablishment() {
        return educationalEstablishment;
    }

    public void setEducationalEstablishment(String educationalEstablishment) {
        this.educationalEstablishment = educationalEstablishment;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public boolean isIsActual() {
        return isActual;
    }

    public void setIsActual(boolean isActual) {
        this.isActual = isActual;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    

}
