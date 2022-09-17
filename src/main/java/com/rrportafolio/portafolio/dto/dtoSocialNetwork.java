
package com.rrportafolio.portafolio.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class dtoSocialNetwork {
    
    @NotNull(message = "Must send an url")
    @NotBlank(message = "Must send an url")
    
    private String url;
    @NotNull(message = "Must send an icon")
    @NotBlank(message = "Must send an icon")
    private String icon;
    @NotNull(message = "Must send an name")
    @NotBlank(message = "Must send an name")
    private String name;
    @NotNull(message = "Must send if is downloable")
    private boolean downloadable;
    @NotNull(message = "Must send an user id")
    private Long idUser;

    public dtoSocialNetwork() {
    }

    public dtoSocialNetwork(String url, String icon, boolean downloadable, Long idUser) {
        this.url = url;
        this.icon = icon;
        this.downloadable = downloadable;
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isDownloadable() {
        return downloadable;
    }

    public void setDownloadable(boolean downloadable) {
        this.downloadable = downloadable;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    
    

}
