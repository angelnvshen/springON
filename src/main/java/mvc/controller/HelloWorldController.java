package mvc.controller;

import com.fasterxml.jackson.annotation.JsonView;
import mvc.model.Pet;
import mvc.model.User;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.List;
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

    /*
    * consumes: request 中的 content-type
    * */
    @ResponseBody
    @RequestMapping(value = "/addPets", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    public String addPet(Pet pet , Model model){
        System.out.println(pet.toString());
        return pet.toString();
    }

    /**
     * params  :  仅处理请求中包含了名为“name”，值为“angel”的请求；
     * @param pet
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addPets2", method = RequestMethod.POST, params = "name=angel")
    public String addPet2(Pet pet , Model model){
        System.out.println(pet.toString());
        return pet.toString();
    }

    /**
     * headers  :  仅处理request的header中包含了指定“name”请求头和对应值为“lov”的请求；
     * @param pet
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addPets3", method = RequestMethod.POST, headers = "name=lov")
    public String addPet3(Pet pet , Model model){
        System.out.println(pet.toString());
        return pet.toString();
    }

    /**
     * @RequestBody
        作用：
        i) 该注解用于读取Request请求的body部分数据，使用系统默认配置的HttpMessageConverter进行解析，然后把相应的数据绑定到要返回的对象上；
        ii) 再把HttpMessageConverter返回的对象数据绑定到 controller中方法的参数上。
        使用时机：
        A) GET、POST方式提时， 根据request header Content-Type的值来判断:
            application/x-www-form-urlencoded， 可选（即非必须，因为这种情况的数据@RequestParam, @ModelAttribute也可以处理，当然@RequestBody也能处理）；
            multipart/form-data, 不能处理（即使用@RequestBody不能处理这种格式的数据）；
            其他格式， 必须（其他格式包括application/json, application/xml等。这些格式的数据，必须使用@RequestBody来处理）；
        B) PUT方式提交时， 根据request header Content-Type的值来判断:
            application/x-www-form-urlencoded， 必须；
            multipart/form-data, 不能处理；
            其他格式， 必须；
        说明：request的body部分的数据编码格式由header部分的Content-Type指定；
     * @param body
     * @param writer
     * @throws IOException
     */
    @RequestMapping(value = "/something")
    public void handle(@RequestBody String body, Writer writer) throws IOException {
        writer.write(body);
    }

    /**
     * The HttpEntity is similar to @RequestBody and @ResponseBody.
     * Besides getting access to the request and response body,
     * HttpEntity (and the response-specific subclass ResponseEntity)
     * also allows access to the request and response headers
     * @param requestEntity
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/something2")
    public ResponseEntity<String> handle2(HttpEntity<byte[]> requestEntity) throws IOException {
        HttpHeaders requestHeader = requestEntity.getHeaders();
        for(Map.Entry<String, List<String>> entry:requestHeader.entrySet()){
            String key  = entry.getKey();
            List<String> values = entry.getValue();
            System.out.println(key + " : " + values);
        }
        byte[] requestBody = requestEntity.getBody();

        System.out.println(new String(requestBody));

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("myResponseHeader", "MyValue");
        return new ResponseEntity<String>(new String(requestBody), responseHeaders , HttpStatus.CREATED);
    }

    @ModelAttribute
    public String addAccount(String name ){
        return "hello " + name;
    }

    @ModelAttribute
    public void addAccount2(String name, Model model){
        model.addAttribute("hurt", " welcom : " + name);
    }

    @ResponseBody
    @RequestMapping("/addAccount3")
    public String addAccount3(@RequestParam String name , HttpServletRequest request){
        System.out.println(request.getParameter("hurt"));
        return "hap";
    }
    @ResponseBody
    @RequestMapping("/addAccount4")
    public String addAccount4(@RequestParam String name , @ModelAttribute(value = "hurt") String hurt){
        System.out.println(name + " , " + hurt);
        return "hap";
    }

    @ResponseBody
    @RequestMapping(value = "/getUser")
    @JsonView(User.WithPasswordView.class)//Object {username: "eric", password: "7!jd#h23"}
    public User getUser(HttpServletRequest request,
                        HttpServletResponse response, Model model) {
        System.out.println(request.getParameter("user2"));
        System.out.println(request.getAttribute("user2"));
        System.out.println(request.getServletPath());// : /getUser
        System.out.println(request.getContextPath());// : /springON
        Map<String ,Object> map = model.asMap();
        for(Map.Entry<String, Object> entry : map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        return new User("eric", "7!jd#h23");
    }

    /**
     * forward 到 view
     * @param model
     * @return
     */
    @RequestMapping("/forwardView")
    public String forwardView(Model model){
        model.addAttribute("userForwad", new User("YIN", "LOV"));
        Map<String ,Object> map = model.asMap();
        for(Map.Entry<String, Object> entry : map.entrySet()){
            System.out.print(entry.getKey());
            System.out.print(" - ");
            System.out.println(entry.getValue());
        }
        return "helloWorld";
    }

    /**
     * forward 到 另一个controller mapping
     * @param model
     * @return
     */
    @RequestMapping("/forwardControllMapping")
    public String forwardControllMapping(Model model){

        Map<String ,Object> map = model.asMap();
        for(Map.Entry<String, Object> entry : map.entrySet()){
            System.out.print(entry.getKey());
            System.out.print(" - ");
            System.out.println(entry.getValue());
        }
        model.addAttribute("userForwad",new User("YIN", "LOIN"));
        return "forward:getForward";
    }

    @RequestMapping("/getForward")
    public String getForward(Model model){
        System.out.println(" ============== ");
        Map<String ,Object> map = model.asMap();
        for(Map.Entry<String, Object> entry : map.entrySet()){
            if(entry.getKey().indexOf("user")!=-1){
                System.out.print(entry.getKey());
                System.out.print(" - ");
                System.out.println(entry.getValue());
            }
        }
        System.out.println(" ============== ");
        for(Map.Entry<String, Object> entry : map.entrySet()){
            if(entry.getKey().indexOf("user")!=-1){
                System.out.print(entry.getKey());
                System.out.print(" - ");
                System.out.println(entry.getValue());
            }
        }
        System.out.println(" ============== ");
        model.addAttribute("userForwad",new User("YIN", "LOING"));

        for(Map.Entry<String, Object> entry : map.entrySet()){
            if(entry.getKey().indexOf("user")!=-1){
                System.out.print(entry.getKey());
                System.out.print(" - ");
                System.out.println(entry.getValue());
            }
        }
        return "helloWorld";
    }

    @RequestMapping("/redirectView")
    public String redirectView(Model model, RedirectAttributes redirectAttributes){
        model.addAttribute("userForwad", new User("YIN", "LOV"));
        Map<String ,Object> map = model.asMap();
        for(Map.Entry<String, Object> entry : map.entrySet()){
            System.out.print(entry.getKey());
            System.out.print(" - ");
            System.out.println(entry.getValue());
        }
        redirectAttributes.addFlashAttribute("userForwad",new User("YIN", "LOS"));
        return "redirect:getForward";
    }

    @RequestMapping(value = "uploadFile")
    public String uploadFile(){
        return "uploadFile";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("name") String name,
                                   @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                System.out.println(file.getName());
                System.out.println(file.getOriginalFilename());

                BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
                String str = "";
                while((str = reader.readLine()) != null)
                    System.out.println(str);

            } catch (IOException e) {
                e.printStackTrace();
            }
            // store the bytes somewhere
            return "redirect:uploadSuccess";
        }

        return "redirect:uploadFailure";
    }

    @RequestMapping("/uploadSuccess")

    public String uploadSuccess(){
        return "uploadSuccess";
    }

    @RequestMapping("/uploadFailure")
    public String uploadFailure(){
        return "uploadFailure";
    }

}
