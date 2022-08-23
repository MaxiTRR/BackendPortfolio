
package com.portfolio.mht.Controller;

import com.portfolio.mht.Dto.DtoExperience;
import com.portfolio.mht.Entity.Experience;

import com.portfolio.mht.Security.Controller.Mensaje;
import com.portfolio.mht.Service.ImpExperienceService;

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
@RequestMapping("explab")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienceController {
    
    @Autowired ImpExperienceService impExperienceService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experience>> list(){
        List<Experience> list = impExperienceService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") Long id){
        if(!impExperienceService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experience experience = impExperienceService.getOne(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperience dtoExperience){
        if(StringUtils.isBlank(dtoExperience.getLugar()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(impExperienceService.existsByLugar(dtoExperience.getLugar()))
            return new ResponseEntity(new Mensaje("Esa Experience existe"), HttpStatus.BAD_REQUEST);
        
        Experience experience = new Experience(dtoExperience.getLugar(),
                                               dtoExperience.getPeriodo(),
                                               dtoExperience.getArea(),
                                               dtoExperience.getRol(),
                                               dtoExperience.getLogo());
        impExperienceService.save(experience);
        return new ResponseEntity(new Mensaje("Experience agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DtoExperience dtoExperience){
        //Validamos si existe el Id
        if(!impExperienceService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de Experience
        if(impExperienceService.existsByLugar(dtoExperience.getLugar()) && impExperienceService.getByLugar(dtoExperience.getLugar()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa Experience ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoExperience.getLugar()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experience experience = impExperienceService.getOne(id).get();
        experience.setLugar(dtoExperience.getLugar());
        experience.setPeriodo(dtoExperience.getPeriodo());
        experience.setArea(dtoExperience.getArea());
        experience.setRol(dtoExperience.getRol());
        experience.setLogo(dtoExperience.getLogo());
        
        impExperienceService.save(experience);
        return new ResponseEntity(new Mensaje("Experience actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        //Validamos si existe el Id
        if(!impExperienceService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        impExperienceService.delete(id);
        
        return new ResponseEntity(new Mensaje("Experience eliminada"), HttpStatus.OK);
    }
    
    
}
