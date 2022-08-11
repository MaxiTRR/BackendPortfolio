
package com.portfolio.mht.Service;

import com.portfolio.mht.Entity.InfoPersonal;
import com.portfolio.mht.Interface.IInfoPersonalService;
import com.portfolio.mht.Repository.IInfoPersonalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpInfoPersonalService implements IInfoPersonalService{
    
    @Autowired IInfoPersonalRepository iInfoPersonalRepository;
    
    @Override
    public List<InfoPersonal> getInfoPersonal() {
        List<InfoPersonal> infoPersonal = iInfoPersonalRepository.findAll();
        return infoPersonal;
    }

    @Override
    public void saveInfoPersonal(InfoPersonal infoPersonal) {
        iInfoPersonalRepository.save(infoPersonal);
    }

    @Override
    public void deleteInfoPersonal(Long id) {
        iInfoPersonalRepository.deleteById(id);
    }

    @Override
    public InfoPersonal findInfoPersonal(Long id) {
        InfoPersonal infoPersonal = iInfoPersonalRepository.findById(id).orElse(null);
        return infoPersonal;
    }
    
}
