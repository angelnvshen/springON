package mvc.advice;

import mvc.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * @ControllerAdviceע���ڲ�ʹ��@ExceptionHandler��@InitBinder��@ModelAttributeע��ķ���Ӧ�õ����е�
 * @RequestMappingע��ķ������ǳ��򵥣�����ֻ�е�ʹ��@ExceptionHandler�����ã����������ô�����
 */
@ControllerAdvice
public class ControllerAdviceTest {

    @ModelAttribute
    public User newUser1(){
        System.out.println("============1Ӧ�õ�����@RequestMappingע�ⷽ��������ִ��֮ǰ�ѷ���ֵ����Model");
        return new User("YIN", "LOV");
    }

    @ModelAttribute
    public void newUser2(Model model){
        System.out.println("============2Ӧ�õ�����@RequestMappingע�ⷽ��������ִ��֮ǰ�ѷ���ֵ����Model");
        model.addAttribute("user2", new User("YIN", "LOV"));
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println("============Ӧ�õ�����@RequestMappingע�ⷽ��������ִ��֮ǰ��ʼ�����ݰ���");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String processUnauthenticatedException(NativeWebRequest request, Exception e) {
        System.out.println("===========Ӧ�õ�����@RequestMappingע��ķ����������׳�UnauthenticatedException�쳣ʱִ��");
        return "error"; //����һ���߼���ͼ��
    }
}
