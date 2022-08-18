
package com.portfolio.mht.Controller;

import com.portfolio.mht.Entity.Project;
import com.portfolio.mht.Interface.IProjectService;
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
public class ProjectController {
    
    @Autowired IProjectService iProjectService;
    
    @GetMapping("project/traer")
    public List<Project> getProject(){
        return iProjectService.getProject();
    }
    
    @PostMapping("project/crear")
    public String createProject(@RequestBody Project project){
        iProjectService.saveProject(project);
        return "El Project fue creado correctamente";
    }
    
    @DeleteMapping("project/borrar/{id}")
    public String deleteProject(@PathVariable Long id){
        iProjectService.deleteProject(id);
        return "El Project fue eliminado correctamente";
    }
    
    @PutMapping("project/editar/{id}")
    public Project editProject(@PathVariable Long id,
                               @RequestParam("tituloPro") String nuevoTituloPro,
                               @RequestParam("tipoPro") String nuevoTipoPro,
                               @RequestParam("periodoPro") String nuevoPeriodoPro,
                               @RequestParam("descripcionPro") String nuevoDescripcionPro,
                               @RequestParam("imgProject") String nuevoImgProject){
        
        Project project = iProjectService.findProject(id);
        
        project.setTituloPro(nuevoTituloPro);
        project.setTipoPro(nuevoTipoPro);
        project.setPeriodoPro(nuevoPeriodoPro);
        project.setDescripcionPro(nuevoDescripcionPro);
        project.setImgProject(nuevoImgProject);
        
        iProjectService.saveProject(project);
        return project;
    }
}
