package pl.springCMS.controller;


//Zadanie 3
//
//    Utwórz kontroler CategoryController, utwórz w nim akcje, które pozwolą:
//
//    wyświetlić listę wszystkich kategorii
//    dodać kategorię
//    usunąć kategorię
//    edytować kategorię
//
//    Dla akcji dodawania oraz edycji utwórz formularz.
//    Utwórz linki nawigacyjne umożliwiające przechodzenie między akcjami - bez konieczności znania adresów URL.

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.springCMS.dao.ArticleDao;
import pl.springCMS.dao.AuthorDao;
import pl.springCMS.dao.CategoryDao;
import pl.springCMS.entity.Category;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("")
//    @ResponseBody
    public String showAll(Model model) {
        model.addAttribute("categories", categoryDao.findAll());
        return "categorylist";
//        return categoryDao.findAll().stream().map(c->c.toString()).collect(Collectors.joining("</div><div>","<div>","</div>"));
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("category", new Category());
        return "categoryform";
    }

    @PostMapping("/add")
    public String add(Category category, @RequestParam String confirm) {
        if(confirm.equals("yes")) {
            categoryDao.save(category);
        }
        return "redirect:/category";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, Model model) {
        model.addAttribute("id", id);
        return "deleteconfirm";
    }

    @PostMapping("/delete")
    public String delete(Model model, @RequestParam Long id, @RequestParam String confirm) {
        if (confirm.equals("yes")) {
            categoryDao.delete(categoryDao.findById(id));
        }
//        model.addAttribute("categories", categoryDao.findAll());
        return "redirect:/category";    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Long id) {
        model.addAttribute("category", categoryDao.findById(id));
        return "categoryform";
    }

    @PostMapping("/edit")
    public String edit(Category category) {
        categoryDao.update(category);
        return "redirect:/category";
    }

    @ModelAttribute("categories")
    public List<Category> findAll()
    {
        return categoryDao.findAll();
    }
}
