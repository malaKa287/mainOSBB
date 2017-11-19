package ua.com.osbb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.osbb.entity.User;
import ua.com.osbb.service.UserService;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/admin")
    public String admin(Principal principal, Model model){

        model.addAttribute("user", principal);
        return "admin";
    }
    @GetMapping("/user")
    public String user(Principal principal, Model model){
        model.addAttribute("user", principal);
        return "user";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/save")
        public String save(@RequestParam("username") String name, @RequestParam("password") String password,
                            @RequestParam("email") String email){
        userService.save(new User(name, password, email));
        return "redirect:/";
    }
}
