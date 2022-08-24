
package com.portfolio.mht.Repository;

import com.portfolio.mht.Entity.InfoPersonal;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInfoPersonalRepository extends JpaRepository<InfoPersonal, Long>{
    
    public Optional<InfoPersonal> findByNombreInfo(String nombreInfo);
    
    public boolean existsByNombreInfo(String nombreInfo);
}
