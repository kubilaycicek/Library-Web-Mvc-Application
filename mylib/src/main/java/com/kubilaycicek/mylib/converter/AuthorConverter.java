package com.kubilaycicek.mylib.converter;

import com.kubilaycicek.mylib.dto.AuthorDto;
import com.kubilaycicek.mylib.entity.Author;

public interface AuthorConverter {
    AuthorDto convertToAuthorDTO(Author author);
    Author convertToAuthor(AuthorDto authorDto);
}
