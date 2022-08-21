
package com.portfolio.mht.Service;

import com.portfolio.mht.Entity.Experience;

import com.portfolio.mht.Repository.IExperienceRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpExperienceService{
    
    @Autowired IExperienceRepository iExperienceRepository;
    
    public List<Experience> list(){
        return iExperienceRepository.findAll();
    }
    
    public Optional<Experience> getOne(Long id){
        return iExperienceRepository.findById(id);
    }
    
    public Optional<Experience> getByLugar(String lugar){
        return iExperienceRepository.findByLugar(lugar);
    }
    
    public void save(Experience experience){
        iExperienceRepository.save(experience);
    }
    
    public void delete(Long id){
        iExperienceRepository.deleteById(id);
    }
    
    public boolean existsById(Long id){
        return iExperienceRepository.existsById(id);
    }
    
    public boolean existsByLugar(String lugar){
        return iExperienceRepository.existsByLugar(lugar);
    }

}
