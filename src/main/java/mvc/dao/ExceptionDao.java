package mvc.dao;

import mvc.model.BusinessException;
import mvc.model.ParameterException;
import org.springframework.stereotype.Repository;

@Repository
public class ExceptionDao {
    public void exception(Integer id) throws Exception {  
        switch(id) {  
        case 1:  
            throw new BusinessException("12", "dao12");
        case 2:  
            throw new BusinessException("22", "dao22");  
        case 3:  
            throw new BusinessException("32", "dao32");  
        case 4:  
            throw new BusinessException("42", "dao42");  
        case 5:  
            throw new BusinessException("52", "dao52");  
        default:  
            throw new ParameterException("Dao Parameter Error");
        }  
    }  
} 