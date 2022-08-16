
package com.portfolio.mht.Interface;

import com.portfolio.mht.Entity.Experience;
import java.util.List;


public interface IExperienceService {
    
    //Traer una lista de Experience
    public List<Experience> getExperience();
    
    //Guardad un objeto de Experience
    public void saveExperience(Experience experience);
    
    //Eliminar una Experience
    public void deleteExperience(Long id);
    
    //Buscar una Experience por id
    public Experience findExperience(Long id);
}
