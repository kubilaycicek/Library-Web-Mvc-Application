package com.kubilaycicek.mylib.api;

import com.kubilaycicek.mylib.constant.Mappings;
import com.kubilaycicek.mylib.dto.AuthorDto;
import com.kubilaycicek.mylib.entity.Author;
import com.kubilaycicek.mylib.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(Mappings.API_CONTROLLER_URL + Mappings.AUTHOR_URL)
@RequiredArgsConstructor
@RestController
public class AuthorRestController {
    private final AuthorService authorService;

    @GetMapping("list")
    public ResponseEntity<List<Author>> getAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthor());
    }

    @PostMapping
    public ResponseEntity<AuthorDto> addAuthor(@RequestBody AuthorDto authorDTO) {
        return ResponseEntity.ok(authorService.addAuthor(authorDTO));
    }

    @PutMapping
    public ResponseEntity<AuthorDto> updateAuthor(@RequestBody AuthorDto authorDTO) {
        return ResponseEntity.ok(authorService.updateAuthor(authorDTO));
    }

    @GetMapping("{authorID}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable(name = "authorID") long authorID) {
        return ResponseEntity.ok(authorService.getByAuthorID(authorID));
    }

    @DeleteMapping("delete/{authorID}")
    public void removeAuthor(@PathVariable(name = "authorID") long authorID) {
        authorService.removeByAuthorID(authorID);
    }
}
