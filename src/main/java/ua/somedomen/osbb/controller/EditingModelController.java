package ua.somedomen.osbb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.somedomen.osbb.entity.News;
import ua.somedomen.osbb.entity.Voting;
import ua.somedomen.osbb.entity.securityEntity.User;
import ua.somedomen.osbb.service.NewsService;
import ua.somedomen.osbb.service.UserService;
import ua.somedomen.osbb.service.VotingService;

@Controller
public class EditingModelController {

    @Autowired
    private VotingService votingService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private UserService userService;


    @PostMapping("/newsUpdate")
    public String testUpdate(
            @RequestParam int id,
            @RequestParam String newsName,
            @RequestParam String newsShort,
            @RequestParam String newsText) {

        News thisis = newsService.findOne(id);

        thisis.setNewsName(newsName);
        thisis.setNewsText(newsShort);
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

    @PostMapping("/votingUpdate")
    public String votingUpdate(
            @RequestParam int id,
            @RequestParam String votingName,
            @RequestParam String votingShort,
            @RequestParam String votingText) {

        Voting thisis = votingService.findOne(id);

        thisis.setVotingName(votingName);
        thisis.setVotingShort(votingShort);
        thisis.setVotingText(votingText);
        votingService.save(thisis);

        return "redirect:/";
    }


}