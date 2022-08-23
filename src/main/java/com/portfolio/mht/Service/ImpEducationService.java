
package com.portfolio.mht.Service;

import com.portfolio.mht.Entity.Education;

import com.portfolio.mht.Repository.IEducationRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpEducationService{
    
    @Autowired IEducationRepository iEducationRepository;

    public List<Education> list(){
        return iEducationRepository.findAll();
    }
    
    public Optional<Education> getOne(Long id){
        return iEducationRepository.findById(id);
    }
    
    public Optional<Education> getByNombreInst(String nombreInst){
        return iEducationRepository.findByNombreInst(nombreInst);
    }
    
    public void save(Education education){
        iEducationRepository.save(education);
    }
    
    public void delete(Long id){
        iEducationRepository.deleteById(id);
    }
    
    public boolean existsById(Long id){
        return iEducationRepository.existsById(id);
    }
    
    public boolean existsByNombreInst(String nombreInst){
        return iEducationRepository.existsByNombreInst(nombreInst);
    }
        
}
