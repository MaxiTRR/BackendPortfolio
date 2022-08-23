
package com.portfolio.mht.Dto;

import javax.validation.constraints.NotBlank;


public class DtoEducation {
    
    @NotBlank
    private String nombreInst;
    
    @NotBlank
    private String periodoEdu;
    
    @NotBlank
    private String tituloEdu;
    
    @NotBlank
    private String descripcionEdu;
    
    @NotBlank
    private String logoEdu;
    
    //Constructors

    public DtoEducation() {
    }

    public DtoEducation(String nombreInst, String periodoEdu, String tituloEdu, String descripcionEdu, String logoEdu) {
        this.nombreInst = nombreInst;
        this.periodoEdu = periodoEdu;
        this.tituloEdu = tituloEdu;
        this.descripcionEdu = descripcionEdu;
        this.logoEdu = logoEdu;
    }
    
    //Getter y Setter

    public String getNombreInst() {
        return nombreInst;
    }

    public void setNombreInst(String nombreInst) {
        this.nombreInst = nombreInst;
    }

    public String getPeriodoEdu() {
        return periodoEdu;
    }

    public void setPeriodoEdu(String periodoEdu) {
        this.periodoEdu = periodoEdu;
    }

    public String getTituloEdu() {
        return tituloEdu;
    }

    public void setTituloEdu(String tituloEdu) {
        this.tituloEdu = tituloEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }

    public String getLogoEdu() {
        return logoEdu;
    }

    public void setLogoEdu(String logoEdu) {
        this.logoEdu = logoEdu;
    }
    
    
}
