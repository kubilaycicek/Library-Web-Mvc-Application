package com.kubilaycicek.mylib.controller;

import com.kubilaycicek.mylib.constant.Mappings;
import com.kubilaycicek.mylib.dto.AuthorDto;
import com.kubilaycicek.mylib.dto.BookDto;
import com.kubilaycicek.mylib.dto.PublisherDto;
import com.kubilaycicek.mylib.service.AuthorService;
import com.kubilaycicek.mylib.service.BookService;
import com.kubilaycicek.mylib.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(Mappings.WEB_CONTROLLER_URL + Mappings.BOOK_URL)
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;

    @GetMapping(value = "list")
    public String list(Model model) {
        model.addAttribute("books", bookService.getAllBook());
        return "book/book-list";
    }

    @GetMapping(value = "new")
    public String showAddForm(Model model) {
        BookDto bookDto = new BookDto();
        bookDto.setAuthorDto(new AuthorDto());
        bookDto.setPublisherDto(new PublisherDto());
        model.addAttribute("bookDto", new BookDto());
        model.addAttribute("authors", authorService.getAllAuthor());
        model.addAttribute("publishers", publisherService.getAllPublisher());
        return "book/book-create";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute BookDto bookDto) {
        bookService.addBook(bookDto);
        return "redirect:list";
    }

    @GetMapping(value = "edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        BookDto bookDto = bookService.getByBookID(id);
        if (bookDto != null) {
            model.addAttribute("authors", authorService.getAllAuthor());
            model.addAttribute("publishers", publisherService.getAllPublisher());
            model.addAttribute("bookDto", bookDto);
        }
        else
            return "404";

        return "book/book-edit";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute(name = "bookDto") BookDto bookDto) {
        bookService.updateBook(bookDto);
        return "redirect:list";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        bookService.removeByBookID(id);
        return "redirect:/web/book/list";
    }
}
