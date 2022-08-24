
package com.portfolio.mht.Dto;

import javax.validation.constraints.NotBlank;


public class DtoProject {
    
    @NotBlank
    private String tituloPro;
    
    @NotBlank
    private String tipoPro;
    
    @NotBlank
    private String periodoPro;
    
    @NotBlank
    private String descripcionPro;
    
    @NotBlank
    private String imgProject;
    
    //Cosntructor

    public DtoProject() {
    }

    public DtoProject(String tituloPro, String tipoPro, String periodoPro, String descripcionPro, String imgProject) {
        this.tituloPro = tituloPro;
        this.tipoPro = tipoPro;
        this.periodoPro = periodoPro;
        this.descripcionPro = descripcionPro;
        this.imgProject = imgProject;
    }
    
    //Getter y Setter

    public String getTituloPro() {
        return tituloPro;
    }

    public void setTituloPro(String tituloPro) {
        this.tituloPro = tituloPro;
    }

    public String getTipoPro() {
        return tipoPro;
    }

    public void setTipoPro(String tipoPro) {
        this.tipoPro = tipoPro;
    }

    public String getPeriodoPro() {
        return periodoPro;
    }

    public void setPeriodoPro(String periodoPro) {
        this.periodoPro = periodoPro;
    }

    public String getDescripcionPro() {
        return descripcionPro;
    }

    public void setDescripcionPro(String descripcionPro) {
        this.descripcionPro = descripcionPro;
    }

    public String getImgProject() {
        return imgProject;
    }

    public void setImgProject(String imgProject) {
        this.imgProject = imgProject;
    }
    
    
}
