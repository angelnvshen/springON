package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Michael on 2015/12/21.
 */
@Controller
public class HelloWorldController {

    @ResponseBody
    @RequestMapping("/helloWorld")
    public String helloWorld(Model model){
        model.addAttribute("message", "Hello World");
        return "helloWorld";
    }

    @ResponseBody
    @RequestMapping(value = "/owners/{ownerId}",method = RequestMethod.GET  )
//    public String findOwner(@PathVariable String ownerId, Model model){
    public String findOwner(@PathVariable("ownerId") String theOnwer, Model model){
        // Owner owner = ownerService.findOwner(ownerId);
        // model.addAttribute("owner", owner);
        return "displayOnwer:"+ " - "+theOnwer ;
    }
}
