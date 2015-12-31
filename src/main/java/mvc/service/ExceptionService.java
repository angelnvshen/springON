package mvc.service;

import mvc.dao.ExceptionDao;
import mvc.model.BusinessException;
import mvc.model.ParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ExceptionService {

    @Autowired
    private ExceptionDao exceptionDao;
      
    public void exception(Integer id) throws Exception {  
        switch(id) {  
        case 1:  
            throw new BusinessException("11", "service11");
        case 2:  
            throw new BusinessException("21", "service21");  
        case 3:  
            throw new BusinessException("31", "service31");  
        case 4:  
            throw new BusinessException("41", "service41");  
        case 5:  
            throw new BusinessException("51", "service51");  
        default:  
            throw new ParameterException("Service Parameter Error");
        }  
    }  
  
    public void dao(Integer id) throws Exception {
        exceptionDao.exception(id);
    }  
}  