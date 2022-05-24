package pl.springCMS.controller;


//Zadanie 4
//
//    Utwórz kontroler AuthorController, utwórz w nim akcje, które pozwolą:
//
//    wyświetlić listę wszystkich autorów
//    dodać autora
//    usunąć autora
//    edytować autora
//
//    Dla akcji dodawania oraz edycji utwórz formularz.
//    Utwórz linki nawigacyjne umożliwiające przechodzenie między akcjami - bez konieczności znania adresów URL.

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.springCMS.dao.ArticleDao;
import pl.springCMS.dao.AuthorDao;
import pl.springCMS.dao.CategoryDao;
import pl.springCMS.entity.Author;
import pl.springCMS.entity.Category;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("")
//    @ResponseBody
    public String showAll(Model model) {
        model.addAttribute("authors", authorDao.findAll());
        return "authorlist";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("author", new Author());
        return "authorform";
    }

    @PostMapping("/add")
    public String add(@Valid Author author, BindingResult result, @RequestParam String confirm) {
        if(confirm.equals("no") ) {
            return "redirect:/author";
        }
        if(result.hasErrors())
        {
            return "authorform";
        }
        if(confirm.equals("yes") ) {
            authorDao.save(author);
        }
        return "redirect:/author";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, Model model) {
        model.addAttribute("id", id);
        return "deleteconfirm";
    }

    @PostMapping("/delete")
    public String delete(Model model, @RequestParam Long id, @RequestParam String confirm) {
        if (confirm.equals("yes")) {
            authorDao.delete(authorDao.findById(id));
        }
        return "redirect:/author";    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam Long id) {
        model.addAttribute("author", authorDao.findById(id));
        return "authorform";
    }

    @PostMapping("/edit")
    public String edit(@Valid Author author, BindingResult result,@RequestParam String confirm) {
        if(confirm.equals("no") ) {
            return "redirect:/author";
        }
        if(result.hasErrors())
        {
            return "authorform";
        }
        if(confirm.equals("yes") )
        {
            authorDao.update(author);
        }
        return "redirect:/author";
    }

    @ModelAttribute("authors")
    public List<Author> findAll()
    {
        return authorDao.findAll();
    }
}
