
package com.portfolio.mht.Service;

import com.portfolio.mht.Entity.Project;

import com.portfolio.mht.Repository.IProjectRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpProjectService{
    
    @Autowired  IProjectRepository iProjectRepository;

   public List<Project> list(){
        return iProjectRepository.findAll();
    }
    
    public Optional<Project> getOne(Long id){
        return iProjectRepository.findById(id);
    }
    
    public Optional<Project> getByTituloPro(String tituloPro){
        return iProjectRepository.findByTituloPro(tituloPro);
    }
    
    public void save(Project project){
        iProjectRepository.save(project);
    }
    
    public void delete(Long id){
        iProjectRepository.deleteById(id);
    }
    
    public boolean existsById(Long id){
        return iProjectRepository.existsById(id);
    }
    
    public boolean existsByTituloPro(String tituloPro){
        return iProjectRepository.existsByTituloPro(tituloPro);
    }
}
