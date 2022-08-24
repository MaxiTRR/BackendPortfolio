
package com.portfolio.mht.Controller;

import com.portfolio.mht.Dto.DtoInfoPersonal;
import com.portfolio.mht.Entity.InfoPersonal;
import com.portfolio.mht.Security.Controller.Mensaje;

import com.portfolio.mht.Service.ImpInfoPersonalService;
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
@RequestMapping("infoPersonal")
@CrossOrigin(origins = "http://localhost:4200")
public class InfoPersonalController {
    
    @Autowired ImpInfoPersonalService impInfoPersonalService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<InfoPersonal>> list(){
        List<InfoPersonal> list = impInfoPersonalService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<InfoPersonal> getById(@PathVariable("id") Long id){
        if(!impInfoPersonalService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        InfoPersonal infoPersonal = impInfoPersonalService.getOne(id).get();
        return new ResponseEntity(infoPersonal, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoInfoPersonal dtoInfoPersonal){
        if(StringUtils.isBlank(dtoInfoPersonal.getNombreInfo()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if(impInfoPersonalService.existsByNombreInfo(dtoInfoPersonal.getNombreInfo()))
            return new ResponseEntity(new Mensaje("Esa InfoPersonal existe"), HttpStatus.BAD_REQUEST);
        
        InfoPersonal infoPersonal = new InfoPersonal(dtoInfoPersonal.getNombreInfo(),
                                                     dtoInfoPersonal.getTitulo(),
                                                     dtoInfoPersonal.getDescripcion(),
                                                     dtoInfoPersonal.getCiudad(),
                                                     dtoInfoPersonal.getFechaNac(),
                                                     dtoInfoPersonal.getImgProfile());
        impInfoPersonalService.save(infoPersonal);
        return new ResponseEntity(new Mensaje("InfoPersonal agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DtoInfoPersonal dtoInfoPersonal){
        //Validamos si existe el Id
        if(!impInfoPersonalService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de InfoPersonal
        if(impInfoPersonalService.existsByNombreInfo(dtoInfoPersonal.getNombreInfo()) && impInfoPersonalService.getByNombreInfo(dtoInfoPersonal.getNombreInfo()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa InfoPersonal ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoInfoPersonal.getNombreInfo()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        InfoPersonal infoPersonal = impInfoPersonalService.getOne(id).get();
        infoPersonal.setNombreInfo(dtoInfoPersonal.getNombreInfo());
        infoPersonal.setTitulo(dtoInfoPersonal.getTitulo());
        infoPersonal.setDescripcion(dtoInfoPersonal.getDescripcion());
        infoPersonal.setCiudad(dtoInfoPersonal.getCiudad());
        infoPersonal.setFechaNac(dtoInfoPersonal.getFechaNac());
        infoPersonal.setImgProfile(dtoInfoPersonal.getImgProfile());
        
        impInfoPersonalService.save(infoPersonal);
        return new ResponseEntity(new Mensaje("InfoPersonal actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        //Validamos si existe el Id
        if(!impInfoPersonalService.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        impInfoPersonalService.delete(id);
        
        return new ResponseEntity(new Mensaje("InfoPersonal eliminada"), HttpStatus.OK);
    }
}
