
package com.portfolio.mht.Controller;

import com.portfolio.mht.Dto.DtoProject;
import com.portfolio.mht.Entity.Project;
import com.portfolio.mht.Security.Controller.Mensaje;
import com.portfolio.mht.Service.ImpProjectService;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("project")
@CrossOrigin(origins="http://localhost:4200")
public class ProjectController {
    
    @Autowired ImpProjectService impProjectService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Project>> list(){
        List<Project> list = impProjectService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Project> getById(@PathVariable("id") Long id){
        if(!impProjectService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Project project = impProjectService.getOne(id).get();
        return new ResponseEntity(project, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProject dtoProject){
        if(StringUtils.isBlank(dtoProject.getTituloPro()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(impProjectService.existsByTituloPro(dtoProject.getTituloPro()))
            return new ResponseEntity(new Mensaje("Esa Experience existe"), HttpStatus.BAD_REQUEST);
        
        Project project = new Project(dtoProject.getTituloPro(),
                                      dtoProject.getTipoPro(),
                                      dtoProject.getPeriodoPro(),
                                      dtoProject.getDescripcionPro(),
                                      dtoProject.getImgProject());
        
        impProjectService.save(project);
        return new ResponseEntity(new Mensaje("Project agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DtoProject dtoProject){
        //Validamos si existe el Id
        if(!impProjectService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de Project
        if(impProjectService.existsByTituloPro(dtoProject.getTituloPro()) && impProjectService.getByTituloPro(dtoProject.getTituloPro()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese Project ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoProject.getTituloPro()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Project project = impProjectService.getOne(id).get();
        project.setTituloPro(dtoProject.getTituloPro());
        project.setTipoPro(dtoProject.getTipoPro());
        project.setPeriodoPro(dtoProject.getPeriodoPro());
        project.setDescripcionPro(dtoProject.getDescripcionPro());
        project.setImgProject(dtoProject.getImgProject());
        
        impProjectService.save(project);
        return new ResponseEntity(new Mensaje("Experience actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        //Validamos si existe el Id
        if(!impProjectService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        impProjectService.delete(id);
        
        return new ResponseEntity(new Mensaje("Project eliminado"), HttpStatus.OK);
    }
}
