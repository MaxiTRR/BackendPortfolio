
package com.portfolio.mht.Service;

import com.portfolio.mht.Entity.InfoPersonal;

import com.portfolio.mht.Repository.IInfoPersonalRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpInfoPersonalService{
    
    @Autowired IInfoPersonalRepository iInfoPersonalRepository;
    
    public List<InfoPersonal> list(){
        return iInfoPersonalRepository.findAll();
    }
    
    public Optional<InfoPersonal> getOne(Long id){
        return iInfoPersonalRepository.findById(id);
    }
    
    public Optional<InfoPersonal> getByNombreInfo(String nombreInfo){
        return iInfoPersonalRepository.findByNombreInfo(nombreInfo);
    }
    
    public void save(InfoPersonal infoPersonal){
        iInfoPersonalRepository.save(infoPersonal);
    }
    
    public void delete(Long id){
        iInfoPersonalRepository.deleteById(id);
    }
    
    public boolean existsById(Long id){
        return iInfoPersonalRepository.existsById(id);
    }
    
    public boolean existsByNombreInfo(String nombreInfo){
        return iInfoPersonalRepository.existsByNombreInfo(nombreInfo);
    }
    
}
