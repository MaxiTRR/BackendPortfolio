
package com.portfolio.mht.Controller;

import com.portfolio.mht.Entity.Experience;
import com.portfolio.mht.Interface.IExperienceService;
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
public class ExperienceController {
    @Autowired IExperienceService iExperienceService;
    
    @GetMapping("experience/traer")
    public List<Experience> getExperience(){
        return iExperienceService.getExperience();
    }
    
    @PostMapping("experience/crear")
    public String createExperience(@RequestBody Experience experience){
        iExperienceService.saveExperience(experience);
        return "La Experiencia fue creada correctamente";
    }
    
    @DeleteMapping("experience/borrar/{id}")
    public String deleteExperience(@PathVariable Long id){
        iExperienceService.deleteExperience(id);
        return "La Experiencia fue eliminada correctamente";
    }
    
    @PutMapping("experience/editar/{id}")
    public Experience editExperience(@PathVariable Long id,
                                     @RequestParam("lugar") String nuevoLugar,
                                     @RequestParam("periodo") String nuevoPeriodo,
                                     @RequestParam("area") String nuevoArea,
                                     @RequestParam("rol") String nuevoRol,
                                     @RequestParam("logo") String nuevoLogo){
        
        Experience experience = iExperienceService.findExperience(id);
        
        experience.setLugar(nuevoLugar);
        experience.setPeriodo(nuevoPeriodo);
        experience.setArea(nuevoArea);
        experience.setRol(nuevoRol);
        experience.setLogo(nuevoLogo);
        
        iExperienceService.saveExperience(experience);
        return experience;
        
    }
}
