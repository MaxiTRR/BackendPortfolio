
package com.portfolio.mht.Service;

import com.portfolio.mht.Entity.Project;
import com.portfolio.mht.Interface.IProjectService;
import com.portfolio.mht.Repository.IProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ImpProjectService implements IProjectService{
    
    @Autowired  IProjectRepository iProjectRepository;

    @Override
    public List<Project> getProject() {
        List<Project> project = iProjectRepository.findAll();
        return project;
    }   

    @Override
    public void saveProject(Project project) {
        iProjectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        iProjectRepository.deleteById(id);
    }

    @Override
    public Project findProject(Long id) {
        Project project = iProjectRepository.findById(id).orElse(null);
        return project;
    }
}
