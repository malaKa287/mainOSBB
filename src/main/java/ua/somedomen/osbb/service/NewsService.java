package ua.somedomen.osbb.service;

import ua.somedomen.osbb.entity.News;

import java.util.List;

public interface NewsService {

    void addNews(News news);


    List<News> findALL();

    News findOne(int newsId);

    News save(News newsName);
}
