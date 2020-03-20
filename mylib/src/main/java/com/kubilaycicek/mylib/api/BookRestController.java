package com.kubilaycicek.mylib.api;

import com.kubilaycicek.mylib.constant.Mappings;
import com.kubilaycicek.mylib.dto.BookDto;
import com.kubilaycicek.mylib.entity.Book;
import com.kubilaycicek.mylib.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequestMapping(Mappings.API_CONTROLLER_URL + Mappings.BOOK_URL)
@RequiredArgsConstructor
@RestController
public class BookRestController {
    private final BookService bookService;

    @GetMapping("list")
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok(bookService.getAllBook());
    }

    @PostMapping
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDTO) {
        return ResponseEntity.ok(bookService.addBook(bookDTO));
    }

    @PutMapping
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDTO) {
        return ResponseEntity.ok(bookService.updateBook(bookDTO));
    }

    @GetMapping("{bookID}")
    public ResponseEntity<BookDto> getBook(@PathVariable(name = "bookID") long bookID) {
        return ResponseEntity.ok(bookService.getByBookID(bookID));
    }

    @DeleteMapping("delete/{bookID}")
    public void removeBook(@PathVariable(name = "bookID") long bookID) {
        bookService.removeByBookID(bookID);
    }
}
