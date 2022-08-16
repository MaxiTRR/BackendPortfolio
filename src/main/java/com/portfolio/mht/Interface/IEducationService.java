
package com.portfolio.mht.Interface;

import com.portfolio.mht.Entity.Education;
import java.util.List;


public interface IEducationService {
    
    //Traer una lista de tipo Education
    public List<Education> getEducation();
    
    //Guardar un objeto de tipo Education
    public void saveEducation(Education education);
    
    //Eliminar una Education
    public void deleteEducation(Long id);
    
    //Buscar una Education por Id
    public Education findEducation(Long id);
}
