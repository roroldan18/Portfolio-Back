
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

@Getter @Setter
@Entity
@Table(name = "portfolio")
public class Portfolio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private String image;
    @NotNull
    private String url;
    @NotNull
    @Column(name = "start_date")
    private Date startDate;
    @NotNull
    @Column(name = "end_date")
    private Date endDate;
    
    @NotNull
    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
    public Portfolio(){
        
    }

    public Portfolio(String name, String description, String image, String url, Date startDate, Date endDate, User user) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.url = url;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
    }
    
    
    
}
