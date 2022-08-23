
package com.portfolio.mht.Repository;

import com.portfolio.mht.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillRepository extends JpaRepository<Skill, Long> {
    
    public Optional<Skill> findByNombre(String nombre);
    
    public boolean existsByNombre(String nombre);
}
