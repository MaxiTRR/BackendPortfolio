
package com.portfolio.mht.Controller;

import com.portfolio.mht.Entity.Education;
import com.portfolio.mht.Interface.IEducationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EducationController {
    
    @Autowired IEducationService iEducationService;
    
    @GetMapping("education/traer")
    public List<Education> getEducation(){
        return iEducationService.getEducation();
    }
    
    @PostMapping("education/crear")
    public String createEducation(@RequestBody Education education){
        iEducationService.saveEducation(education);
        return "La Education fue creada correctamente";
    }
    
    @DeleteMapping("education/borrar/{id}")
    public String deleteEducation(@PathVariable Long id){
        iEducationService.deleteEducation(id);
        return "La Education fue eliminada correctamente";
    }
    
    @PutMapping("education/editar/{id}")
    public Education editEducation(@PathVariable Long id,
                                   @RequestParam("nombreInst") String nuevoNombreInst,
                                   @RequestParam("periodoEdu") String nuevoPeriodoEdu,
                                   @RequestParam("tituloEdu") String nuevoTituloEdu,
                                   @RequestParam("descripcionEdu") String nuevoDescripcionEdu,
                                   @RequestParam("logoEdu") String nuevoLogoEdu){
        
        Education education = iEducationService.findEducation(id);
        
        education.setNombreInst(nuevoNombreInst);
        education.setPeriodoEdu(nuevoPeriodoEdu);
        education.setTituloEdu(nuevoTituloEdu);
        education.setDescripcionEdu(nuevoDescripcionEdu);
        education.setLogoEdu(nuevoLogoEdu);
        
        iEducationService.saveEducation(education);
        return education;
        
    }
}
