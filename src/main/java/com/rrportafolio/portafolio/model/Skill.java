
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
@Table(name = "skill")
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique=true)
    private String name;
    @NotNull
    private String icon;
    @NotNull
    @Column(name="ability_percentage")
    private int abilityPercentage;
    
    @NotNull
    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Skill(String name, String icon, int abilityPercentage, User user) {
        this.name = name;
        this.icon = icon;
        this.abilityPercentage = abilityPercentage;
        this.user = user;
    }

    public Skill() {
    }
        

    
    
}
