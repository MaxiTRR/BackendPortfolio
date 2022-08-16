
package com.portfolio.mht.Service;

import com.portfolio.mht.Entity.Education;
import com.portfolio.mht.Interface.IEducationService;
import com.portfolio.mht.Repository.IEducationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpEducationService implements IEducationService {
    
    @Autowired IEducationRepository iEducationRepository;

    @Override
    public List<Education> getEducation() {
        List<Education> education = iEducationRepository.findAll();
        return education;
        
    }
    @Override
    public void saveEducation(Education education) {
        iEducationRepository.save(education);
        
    }

    @Override
    public void deleteEducation(Long id) {
        iEducationRepository.deleteById(id);
    }

    @Override
    public Education findEducation(Long id) {
        Education education = iEducationRepository.findById(id).orElse(null);
        return education;
    }
        
}
