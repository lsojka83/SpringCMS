package pl.springCMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.springCMS.dao.ArticleDao;
import pl.springCMS.dao.AuthorDao;
import pl.springCMS.dao.CategoryDao;
import pl.springCMS.entity.Article;

import java.util.List;
import java.util.stream.Collectors;

//Zadanie 2
//
//    Utwórz kontroler HomePageController,
//    Utwórz akcję startową o nazwie home() dostępną pod adresem /, wyświetlającą 5 ostatnio dodanych artykułów.
//    Wyświetlamy tytuł, datę dodania oraz zawartość danego artykułu.

@Controller
public class HomePageController {

    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    public HomePageController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("")
    public String home()
    {
        return "articlelist";
    }

    @ModelAttribute("articles")
    public List<Article> getLatestFive()
    {
        return articleDao.getLatestFive();
    }

}
