package pl.springCMS.controller;


//Zadanie 5
//
//    Utwórz kontroler ArticleController, utwórz w nim akcje, które pozwolą:
//
//    wyświetlić listę wszystkich artykułów
//    dodać artykuł
//    usunąć artykuł
//    edytować artykuł
//
//    Dla akcji dodawania oraz edycji utwórz formularz.
//    Formularz tworzenia ma zawierać pola z możliwością wyboru autora.
//    Formularz tworzenia ma zawierać pola z możliwością wyboru wielu kategorii.
//    Dodaj konwertery dla klas Author oraz Category.
//    Utwórz linki nawigacyjne umożliwiające przechodzenie między akcjami - bez konieczności znania adresów URL.

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.springCMS.dao.ArticleDao;
import pl.springCMS.dao.AuthorDao;
import pl.springCMS.dao.CategoryDao;
import pl.springCMS.entity.Article;
import pl.springCMS.entity.Author;
import pl.springCMS.entity.Category;

import java.awt.*;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    public ArticleController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("")
    public String showAll(Model model) {
        model.addAttribute("articles", articleDao.findAll());
        return "articlelist";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("article", new Article());
        return "articleform";
    }

    @PostMapping("/add")
    public String add(Article article, @RequestParam String confirm) {
        if(confirm.equals("yes")) {
            articleDao.save(article);
        }
        return "redirect:/article";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, Model model) {
        model.addAttribute("id", id);
        return "deleteconfirm";
    }

    @PostMapping("/delete")
    public String delete(Model model, @RequestParam Long id, @RequestParam String confirm) {
        if (confirm.equals("yes")) {
            articleDao.delete(articleDao.findById(id));
        }
        return "redirect:/article";    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Long id) {
        model.addAttribute("article", articleDao.findById(id));
        return "articleform";
    }

    @PostMapping("/edit")
    public String edit(Article article, @RequestParam String confirm) {
        if(confirm.equals("yes")) {
            articleDao.update(article);
        }
        return "redirect:/article";
    }

    @ModelAttribute("articles")
    public List<Article> findAll()
    {
        return articleDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> findAllAuthors()
    {
        return authorDao.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> findAllCategories()
    {
        return categoryDao.findAll();
    }
}
