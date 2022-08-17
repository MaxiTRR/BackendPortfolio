
package com.portfolio.mht.Interface;

import com.portfolio.mht.Entity.Skill;
import java.util.List;


public interface ISkillService {
    
    //Traer una lista de Skill
    public List<Skill> getSkill();
        
    //Guardar un objeto de tipo Skill
    public void saveSkill(Skill skill);
    
    //Eliminar una Skill
    public void deleteSkill(Long id);
    
    //Buscar una Skill por Id
    public Skill findSkill(Long id); 
}
