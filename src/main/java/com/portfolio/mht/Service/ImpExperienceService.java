
package com.portfolio.mht.Service;

import com.portfolio.mht.Entity.Experience;
import com.portfolio.mht.Interface.IExperienceService;
import com.portfolio.mht.Repository.IExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpExperienceService implements IExperienceService{
    
    @Autowired IExperienceRepository iExperienceRepository;

    @Override
    public List<Experience> getExperience() {
        List<Experience> experience = iExperienceRepository.findAll();
        return experience;
    }

    @Override
    public void saveExperience(Experience experience) {
        iExperienceRepository.save(experience);
            
    }

    @Override
    public void deleteExperience(Long id) {
        iExperienceRepository.deleteById(id);
    }

    @Override
    public Experience findExperience(Long id) {
        Experience experience = iExperienceRepository.findById(id).orElse(null);
        return experience;
    }
    
    
}
