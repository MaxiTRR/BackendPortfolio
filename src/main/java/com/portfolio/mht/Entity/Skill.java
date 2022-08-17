
package com.portfolio.mht.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min=1, max=50, message="No cumple con la longitud")
    private String nombre;
    
    @NotNull
    @Min(value = 1, message = "El Nivel no debe ser menor a 1(uno)")
    @Max(value = 100, message = "El Nivel no debe ser mayor a 100(cien)")
    private Long nivel;
}
