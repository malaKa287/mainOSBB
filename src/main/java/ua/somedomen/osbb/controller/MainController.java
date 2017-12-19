package ua.somedomen.osbb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.somedomen.osbb.entity.Comments;
import ua.somedomen.osbb.entity.News;
import ua.somedomen.osbb.service.NewsService;

import java.util.Date;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    private NewsService newsService;



    @PostMapping("/addNews")
    public String addNews(
            @RequestParam("newsName") String newsName,
            @RequestParam("newsText") String newsText){
        newsService.addNews(new News(newsName, newsText));

        return "redirect:/";
    }

    @PostMapping("/addComment")
    public String addComment(
            @RequestParam int id,
            @RequestParam String commentValue){

        News thisis = newsService.findOne(id);

        List<Comments> commentsList = thisis.getNewsComment();
        commentsList.add(new Comments(commentValue, String.valueOf(new Date()), thisis));

        thisis.setNewsName(thisis.getNewsName());
        thisis.setNewsText(thisis.getNewsText());
        thisis.setNewsComment(commentsList);

        newsService.save(thisis);

        return "redirect:/";
    }
}