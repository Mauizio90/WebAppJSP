package eu.mauizio90.webAppMaurizio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author mauiz
 */
@Controller
public class SayHelloController {
    
    @RequestMapping("/say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello! cosa stai imparando oggi?";
    }
    
    @RequestMapping("/say-hello-html")
    @ResponseBody
    public String sayHelloHtml(){
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> Pagina HTML - Mauriziolo</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("Pagina html con Body - Maurizio");
        sb.append("</body>");
        sb.append("</html>");
        
        return sb.toString();
    }
    
    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp(){
        return "sayHello";
    }
}
