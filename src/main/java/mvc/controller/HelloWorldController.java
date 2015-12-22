package mvc.controller;

import mvc.model.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Michael on 2015/12/21.
 */
@Controller
public class HelloWorldController {

//    @ResponseBody
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

    // url pattern with regular expression
    @ResponseBody
    @RequestMapping("/spring-webL/{symbolicName:[a-z-]+}-{version:\\d+\\.\\d+\\.\\d+}{extension:\\.[a-z]+}")
    public String handle(@PathVariable String version, @PathVariable String extension){
        return "version : " + version + ", extension : " + extension;
    }

    @ResponseBody
    @RequestMapping(value="/products/{categoryCode:\\d+}-{pageNumber:\\d+}")
    public String handle2(@PathVariable("categoryCode") String version, @PathVariable("pageNumber") String extension){
        return "version : " + version + ", extension : " + extension;
    }

    // url pattern with matrix variables

    @ResponseBody
    @RequestMapping(value = "/owners/{ownerId}/pets/{petId}")
    public String findPet(@MatrixVariable(value = "q", pathVar = "ownerId", required = false, defaultValue = "1") String q,
                          @MatrixVariable(value="p", pathVar="petId", required = false, defaultValue = "2") String p){
        return "q : " + q + ", p : " + p;
    }

    @ResponseBody
    @RequestMapping(value = "/owners/{ownerId}/pets2/{petId}")
    public String findPet2(@MatrixVariable(required = false, defaultValue = "1") Map<String, String> matrixValues,
                          @MatrixVariable(pathVar="petId", required = false, defaultValue = "2") Map<String, String> petValues){
        return "matrixValues : " + matrixValues + ", petValues : " + petValues;
    }

    @ResponseBody
    @RequestMapping(value = "/addPets", method = RequestMethod.POST, consumes = "application/json")
    public String addPet(Pet pet , Model model){
        return pet.toString();
    }







}
