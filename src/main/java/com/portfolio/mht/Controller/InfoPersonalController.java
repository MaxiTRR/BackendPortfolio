
package com.portfolio.mht.Controller;

import com.portfolio.mht.Entity.InfoPersonal;
import com.portfolio.mht.Interface.IInfoPersonalService;
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
@CrossOrigin(origins = "http://localhost:4200")
public class InfoPersonalController {
    @Autowired IInfoPersonalService iInfoPersonalService;
    
    @GetMapping("infoPersonal/traer")
    public List<InfoPersonal> getInfoPersonal(){
        return iInfoPersonalService.getInfoPersonal();
    }
    
    @PostMapping("infoPersonal/crear")
    public String createInfoPersonal(@RequestBody InfoPersonal infoPersonal){
        iInfoPersonalService.saveInfoPersonal(infoPersonal);
        return "La InfoPersonal fue creada correctamente";
    }
    
    @DeleteMapping("infoPersonal/borrar/{id}")
    public String deleteInfoPersonal(@PathVariable Long id){
        iInfoPersonalService.deleteInfoPersonal(id);
        return "La InfoPersonal fue eliminada correctamente";
    }
    
    @PutMapping("infoPersonal/editar/{id}")
    public InfoPersonal editInfoPersonal(@PathVariable Long id,
                                         @RequestParam("nombreInfo") String nuevoNombreInfo,
                                         @RequestParam("titulo") String nuevoTitulo,
                                         @RequestParam("descripcion") String nuevoDescripcion,
                                         @RequestParam("imgProfile") String nuevoImgProfile){
        
        InfoPersonal infoPersonal = iInfoPersonalService.findInfoPersonal(id);
        
        infoPersonal.setNombreInfo(nuevoNombreInfo);
        infoPersonal.setTitulo(nuevoTitulo);
        infoPersonal.setDescripcion(nuevoDescripcion);
        infoPersonal.setImgProfile(nuevoImgProfile);
        
        iInfoPersonalService.saveInfoPersonal(infoPersonal);
        return infoPersonal;
    }
    
    @GetMapping("infoPersonal/traer/perfil")
    public InfoPersonal findInfoPersonal(){
        return iInfoPersonalService.findInfoPersonal((long)2);
    }
}
