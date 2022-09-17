package com.rrportafolio.portafolio.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class dtoSkill {
    @NotNull(message = "Must send a name")
    @NotBlank(message = "Must send a name")
    private String name;
    @NotNull(message = "Must send a icon")
    @NotBlank(message = "Must send a icon")
    private String icon;
    @NotNull(message = "Must send a abilityPercentage")
    private int abilityPercentage;
    @NotNull(message = "Must send an user id")
    private Long idUser;

    public dtoSkill() {
    }

    public dtoSkill(String name, String icon, int abilityPercentage, Long idUser) {
        this.name = name;
        this.icon = icon;
        this.abilityPercentage = abilityPercentage;
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getAbilityPercentage() {
        return abilityPercentage;
    }

    public void setAbilityPercentage(int abilityPercentage) {
        this.abilityPercentage = abilityPercentage;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    
    

}
