
package com.portfolio.mht.Dto;

import javax.validation.constraints.NotBlank;


public class DtoInfoPersonal {
    
    @NotBlank
    private String nombreInfo;
    
    @NotBlank
    private String titulo;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    private String ciudad;
    
    @NotBlank
    private String fechaNac;
    
    @NotBlank
    private String imgProfile;
    
    //Constructor

    public DtoInfoPersonal() {
    }

    public DtoInfoPersonal(String nombreInfo, String titulo, String descripcion, String ciudad, String fechaNac, String imgProfile) {
        this.nombreInfo = nombreInfo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ciudad = ciudad;
        this.fechaNac = fechaNac;
        this.imgProfile = imgProfile;
    }
    
    //Getter y Setter

    public String getNombreInfo() {
        return nombreInfo;
    }

    public void setNombreInfo(String nombreInfo) {
        this.nombreInfo = nombreInfo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(String imgProfile) {
        this.imgProfile = imgProfile;
    }
    
}
