package ua.somedomen.osbb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.somedomen.osbb.entity.News;
import ua.somedomen.osbb.entity.securityEntity.User;
import ua.somedomen.osbb.service.NewsService;
import ua.somedomen.osbb.service.UserService;

@Controller
public class EditingModelController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private UserService userService;


    @PostMapping("/newsUpdate")
    public String testUpdate(
            @RequestParam int id,
            @RequestParam String newsName,
            @RequestParam String newsText) {

        News thisis = newsService.findOne(id);

        thisis.setNewsName(newsName);
        thisis.setNewsText(newsText);
        newsService.save(thisis);

        return "redirect:/";
    }

    @PostMapping("/updatePersonalInfo")
    public String updatePersonalInfo(
            @RequestParam int id,
            @RequestParam String email,
            @RequestParam String name,
            @RequestParam String prename,
            @RequestParam String phoneNumber,
            @RequestParam String someInfo) {

        User thisis = userService.findOne(id);

        thisis.setEmail(email);
        thisis.setName(name);
        thisis.setPrename(prename);
        thisis.setPhoneNumber(phoneNumber);
        thisis.setSomeInfo(someInfo);
        userService.saveWithoutPassword(thisis);

        return "redirect:/";
    }

}