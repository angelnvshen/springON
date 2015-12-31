package mvc.controller;

import mvc.model.BusinessException;
import mvc.model.ParameterException;
import mvc.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExceptionController extends BaseController {

    @Autowired
    private ExceptionService exceptionService;
      
    @RequestMapping(value = "exController", method = RequestMethod.GET)
    public void controller(Integer id) throws Exception {
        switch(id) {  
        case 1:  
            throw new BusinessException("10", "controller10");  
        case 2:  
            throw new BusinessException("20", "controller20");  
        case 3:  
            throw new BusinessException("30", "controller30");  
        case 4:  
            throw new BusinessException("40", "controller40");  
        case 5:  
            throw new BusinessException("50", "controller50");
        default:  
            throw new ParameterException("Controller Parameter Error");
        }  
    }  
      
    @RequestMapping(value = "exService", method = RequestMethod.GET)
    public void service(Integer id) throws Exception {
        exceptionService.exception(id);
    }  
      
    @RequestMapping(value = "exDao", method = RequestMethod.GET)
    public void dao(Integer id) throws Exception {
        exceptionService.dao(id);
    }  
}  