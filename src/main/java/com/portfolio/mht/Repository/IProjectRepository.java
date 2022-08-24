
package com.portfolio.mht.Repository;

import com.portfolio.mht.Entity.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long> {
    
    public Optional<Project> findByTituloPro(String tituloPro);
    
    public boolean existsByTituloPro(String tituloPro);
}
