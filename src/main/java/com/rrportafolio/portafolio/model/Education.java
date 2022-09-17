
package com.rrportafolio.portafolio.model;

import java.util.Date;
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

@Entity
@Table(name = "education")
public class Education {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "career_title")
    private String careerTitle;
    @NotNull
    @Column(name = "educational_establishment")
    private String educationalEstablishment;
    private String image;
    @NotNull
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @NotNull
    private boolean isActual;
    
    @NotNull
    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Education() {
    }

    public Education(String careerTitle, String educationalEstablishment, String image, Date startDate, Date endDate, boolean isActual, User user) {
        this.careerTitle = careerTitle;
        this.educationalEstablishment = educationalEstablishment;
        this.image = image;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActual = isActual;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
    
    

}
