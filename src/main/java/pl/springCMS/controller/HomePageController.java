package pl.springCMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.springCMS.dao.ArticleDao;
import pl.springCMS.entity.Article;

import java.util.stream.Collectors;

@Controller
public class HomePageController {

    private final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @GetMapping("")
    @ResponseBody
    public String home()
    {
        return articleDao.findAll().stream().limit(5).map(a->a.toString()).collect(Collectors.joining("\n"));

//        return "";
    }

    @GetMapping("/add")
    @ResponseBody
    public String add(@RequestParam String title)
    {
        Article article = new Article(title);
        articleDao.save(article);
        return String.format("Article id=%s created", article.getId());
    }
}
