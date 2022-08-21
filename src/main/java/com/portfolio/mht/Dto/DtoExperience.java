
package com.portfolio.mht.Dto;

import javax.validation.constraints.NotBlank;


public class DtoExperience {
    
    @NotBlank
    private String lugar;
    
    @NotBlank
    private String periodo;
    
    @NotBlank
    private String area;
    
    @NotBlank
    private String rol;
    
    @NotBlank
    private String logo;
    
    //Constructors
    public DtoExperience() {
    }

    public DtoExperience(String lugar, String periodo, String area, String rol, String logo) {
        this.lugar = lugar;
        this.periodo = periodo;
        this.area = area;
        this.rol = rol;
        this.logo = logo;
    }
    
    //Getter y Setter
    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
   
}
