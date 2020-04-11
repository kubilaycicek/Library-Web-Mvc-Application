package com.kubilaycicek.mylib.controller;

import com.kubilaycicek.mylib.constant.Mappings;
import com.kubilaycicek.mylib.dto.AuthorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import com.kubilaycicek.mylib.service.AuthorService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(Mappings.WEB_CONTROLLER_URL + Mappings.AUTHOR_URL)
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping(value = "/list")
    public String list(Model model) {
        model.addAttribute("authors", authorService.getAllAuthor());
        return "author/author-list";
    }

    @GetMapping(value = "/new")
    public String showAddForm(@ModelAttribute(name = "authorDto") AuthorDto authorDto) {
        return "author/author-create";
    }

    @PostMapping(value = "/add")
    public String add(@ModelAttribute(name = "authorDto") AuthorDto authorDto) {
        System.out.println(authorDto.toString());
        authorService.addAuthor(authorDto);
        return "redirect:/web/author/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        AuthorDto authorDto = authorService.getByAuthorID(id);
        if (authorDto != null)
            model.addAttribute("authorDto", authorDto);
        else
            return "404";
        return "author/author-edit";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        authorService.removeByAuthorID(id);
        return "redirect:/web/author/list";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute(name = "authorDto") AuthorDto authorDto) {
        authorService.updateAuthor(authorDto);
        return "redirect:/web/author/list";
    }
}
