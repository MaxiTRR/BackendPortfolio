
package com.portfolio.mht.Repository;

import com.portfolio.mht.Entity.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienceRepository extends JpaRepository<Experience, Long> {
    
    public Optional<Experience> findByLugar(String lugar);
    
    public boolean existsByLugar(String lugar);
}
