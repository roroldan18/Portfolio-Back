
package com.rrportafolio.portafolio.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class dtoExperience {

    @NotNull(message = "Must send a company")
    @NotBlank(message = "Must send a company")
    private String company;
    @NotNull(message = "Must send a title")
    @NotBlank(message = "Must send a title")
    private String title;
    @NotNull(message = "Must send a description")
    @NotBlank(message = "Must send a description")
    private String description;
    @NotNull(message = "Must send a timeWork")
    @NotBlank(message = "Must send a timeWork")
    private String timeWork;
    @NotNull(message = "Must send a startDate")
    private Date startDate;
    private Date endDate;
    @NotNull(message = "Must send a Logo")
    @NotBlank(message = "Must send a Logo")
    private String logo;
    @NotNull(message = "Must send a isActual")
    private boolean isActual;
    @NotNull(message = "Must send an user id")
    private Long idUser;
    
    
    public dtoExperience() {
        
    }

    public dtoExperience(String company, String title, String description, String timeWork, Date startDate, Date endDate, String logo, boolean isActual, Long idUser) {
        this.company = company;
        this.title = title;
        this.description = description;
        this.timeWork = timeWork;
        this.startDate = startDate;
        this.endDate = endDate;
        this.logo = logo;
        this.isActual = isActual;
        this.idUser = idUser;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

   
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(String timeWork) {
        this.timeWork = timeWork;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public boolean getIsActual() {
        return isActual;
    }

    public void setIsActual(boolean isActual) {
        this.isActual = isActual;
    }
    
    
    
}
