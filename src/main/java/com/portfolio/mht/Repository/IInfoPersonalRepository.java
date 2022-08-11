
package com.portfolio.mht.Repository;

import com.portfolio.mht.Entity.InfoPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInfoPersonalRepository extends JpaRepository<InfoPersonal, Long>{
    
}
