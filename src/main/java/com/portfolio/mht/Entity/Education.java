
package com.portfolio.mht.Entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Education {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min=1, max=50, message="No cumple con la longitud" )
    private String nombreInst;
    
    
    @NotNull
    @Size(min=1, max=50, message="No cumple con la longitud" )
    private String periodoEdu;
    
    @NotNull
    @Size(min=1, max=50, message="No cumple con la longitud" )
    private String tituloEdu;
    
    @NotNull
    @Size(min=1, max=300, message="No cumple con la longitud" )
    private String descripcionEdu;
    
    private String logoEdu;
}
