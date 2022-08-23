
package com.portfolio.mht.Controller;

import com.portfolio.mht.Dto.DtoEducation;
import com.portfolio.mht.Entity.Education;
import com.portfolio.mht.Security.Controller.Mensaje;
import com.portfolio.mht.Service.ImpEducationService;

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
@RequestMapping("education")
@CrossOrigin(origins = "http://localhost:4200")
public class EducationController {
    
    @Autowired ImpEducationService impEducationService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Education>> list(){
        List<Education> list = impEducationService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") Long id){
        if(!impEducationService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Education education = impEducationService.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducation dtoEducation){
        if(StringUtils.isBlank(dtoEducation.getNombreInst()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        
        
        Education education = new Education(dtoEducation.getNombreInst(),
                                            dtoEducation.getPeriodoEdu(),
                                            dtoEducation.getTituloEdu(),
                                            dtoEducation.getDescripcionEdu(),
                                            dtoEducation.getLogoEdu());
        
        impEducationService.save(education);
        return new ResponseEntity(new Mensaje("Education agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DtoEducation dtoEducation){
        //Validamos si existe el Id
        if(!impEducationService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de Experience
        if(impEducationService.existsByNombreInst(dtoEducation.getNombreInst()) && impEducationService.getByNombreInst(dtoEducation.getNombreInst()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa Education ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoEducation.getNombreInst()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Education education = impEducationService.getOne(id).get();
        education.setNombreInst(dtoEducation.getNombreInst());
        education.setPeriodoEdu(dtoEducation.getPeriodoEdu());
        education.setTituloEdu(dtoEducation.getTituloEdu());
        education.setDescripcionEdu(dtoEducation.getDescripcionEdu());
        education.setLogoEdu(dtoEducation.getLogoEdu());
        
        impEducationService.save(education);
        return new ResponseEntity(new Mensaje("Education actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        //Validamos si existe el Id
        if(!impEducationService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        impEducationService.delete(id);
        return new ResponseEntity(new Mensaje("Education eliminada"), HttpStatus.OK);
    }
    
    
}
