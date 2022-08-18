
package com.portfolio.mht.Interface;
import com.portfolio.mht.Entity.Project;
import java.util.List;

public interface IProjectService {
    
    //Traer una lista de Project
    public List<Project> getProject();
        
    //Guardar un objeto de tipo Project
    public void saveProject(Project project);
    
    //Eliminar un Project
    public void deleteProject(Long id);
    
    //Buscar un Project por Id
    public Project findProject(Long id);
}
