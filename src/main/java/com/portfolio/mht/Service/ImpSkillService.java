
package com.portfolio.mht.Service;

import com.portfolio.mht.Entity.Skill;

import com.portfolio.mht.Repository.ISkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpSkillService{
    
    @Autowired ISkillRepository iSkillRepository;

    public List<Skill> list(){
        return iSkillRepository.findAll();
    }
    
    public Optional<Skill> getOne(Long id){
        return iSkillRepository.findById(id);
    }
    
    public Optional<Skill> getByNombre(String nombre){
        return iSkillRepository.findByNombre(nombre);
    }
    
    public void save(Skill skill){
        iSkillRepository.save(skill);
    }
    
    public void delete(Long id){
        iSkillRepository.deleteById(id);
    }
    
    public boolean existsById(Long id){
        return iSkillRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return iSkillRepository.existsByNombre(nombre);
    }

}
