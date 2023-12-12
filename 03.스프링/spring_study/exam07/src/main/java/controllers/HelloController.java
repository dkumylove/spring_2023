package controllers;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "기본값") String nm, @RequestParam(value = "name2", required = false) String nm2, Model model) {
        model.addAttribute("name", nm);
        model.addAttribute("name2", nm2);

        return "hello";
    }

    /*
    @GetMapping("/hello")
    //public String hello(@RequestParam("name") String name, @RequestParam("num") int num){
    public String hello(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println("=====request : " + request);
        System.out.println("=====response : " + response);
        System.out.println("=====session : " + session);
        //System.out.println("name : " + name + ", num : " + num);
        return "hello";   // /WEB-INF/templates/hello.jsp
    }
    */
    /*
    @GetMapping("/hello")
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        // request.setAttribute("message", "안녕하세요.");
        mv.addObject("message", "안녕하세요.");
        mv.setViewName("hello"); // /WEB-INF/templates/hello.jsp

        return mv;
    }
    */
}
