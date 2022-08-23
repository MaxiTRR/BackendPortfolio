
package com.portfolio.mht.Dto;

import javax.validation.constraints.NotBlank;


public class DtoSkill {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private Long nivel;
    
    //Constructor

    public DtoSkill() {
    }

    public DtoSkill(String nombre, Long nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
    
    //Getter y Setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNivel() {
        return nivel;
    }

    public void setNivel(Long nivel) {
        this.nivel = nivel;
    }
    
    
}
