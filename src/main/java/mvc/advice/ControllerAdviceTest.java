package mvc.advice;

import mvc.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * Created by bf50 on 2015/12/31.
 */
//@ControllerAdvice
public class ControllerAdviceTest {
    /**
     * @ControllerAdvice注解内部使用@ExceptionHandler、@InitBinder、@ModelAttribute注解的方法应用到所有的
     * @RequestMapping注解的方法。非常简单，不过只有当使用@ExceptionHandler最有用，另外两个用处不大。
     */
    @ModelAttribute
    public User newUser1(){
        System.out.println("============1应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model");
        return new User("YIN", "LOV");
    }
    @ModelAttribute
    public void newUser2(Model model){
        System.out.println("============2应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model");
        model.addAttribute("user2", new User("YIN", "LOV"));

    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String processUnauthenticatedException(NativeWebRequest request, Exception e) {
        return "error"; //返回一个逻辑视图名
    }

}
