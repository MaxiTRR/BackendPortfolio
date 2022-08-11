
package com.portfolio.mht.Interface;

import com.portfolio.mht.Entity.InfoPersonal;
import java.util.List;


public interface IInfoPersonalService {
    
    //Traer una lista de  InfoPersonal
    public List<InfoPersonal> getInfoPersonal();
        
    //Guardar un objeto de tipo InfoPersonal
    public void saveInfoPersonal(InfoPersonal infoPersonal);
    
    //Eliminar una InfoPersonal
    public void deleteInfoPersonal(Long id);
    
    //Buscar una InfoPersonal por Id
    public InfoPersonal findInfoPersonal(Long id); 
}
