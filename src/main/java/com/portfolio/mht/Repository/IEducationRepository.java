
package com.portfolio.mht.Repository;

import com.portfolio.mht.Entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationRepository extends JpaRepository<Education, Long> {
    
}
