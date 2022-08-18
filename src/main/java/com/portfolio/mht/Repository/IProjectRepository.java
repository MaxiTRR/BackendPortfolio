
package com.portfolio.mht.Repository;

import com.portfolio.mht.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProjectRepository extends JpaRepository<Project, Long> {
    
}
