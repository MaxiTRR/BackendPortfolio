
package com.portfolio.mht.Controller;

import com.portfolio.mht.Entity.InfoPersonal;
import com.portfolio.mht.Entity.Skill;
import com.portfolio.mht.Interface.ISkillService;
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
@CrossOrigin(origins="http://localhost:4200")
public class SkillController {
    
    @Autowired ISkillService iSkillService;
    
    @GetMapping("skill/traer")
    public List<Skill> getSkill(){
        return iSkillService.getSkill();
    }
    
    @PostMapping("skill/crear")
    public String createSkill(@RequestBody Skill skill){
        iSkillService.saveSkill(skill);
        return "La Skill fue creada correctamente";
    }
    
    @DeleteMapping("skill/borrar/{id}")
    public String deleteSkill(@PathVariable Long id){
        iSkillService.deleteSkill(id);
        return "La Skill fue eliminada correctamente";
    }
    
    @PutMapping("skill/editar/{id}")
    public Skill editSkill(@PathVariable Long id,
                           @RequestParam("nombre") String nuevoNombre,
                           @RequestParam("nivel") Long nuevoNivel
                           ){
        
        Skill skill = iSkillService.findSkill(id);
        
        skill.setNombre(nuevoNombre);
        skill.setNivel(id);
        
        iSkillService.saveSkill(skill);
        return skill;
    }
}
