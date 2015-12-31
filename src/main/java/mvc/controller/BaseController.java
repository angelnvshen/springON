package mvc.controller;

import mvc.model.BusinessException;
import mvc.model.ParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    /** 基于@ExceptionHandler异常处理 */  
    @ExceptionHandler
    public String exp(HttpServletRequest request, Exception ex) {
          
        request.setAttribute("ex", ex);  
          
        // 根据不同错误转向不同页面  
        if(ex instanceof BusinessException) {
            return "ex-error-business";
        }else if(ex instanceof ParameterException) {
            return "ex-error-parameter";
        } else {  
            return "ex-error";
        }  
    }  
}  