package com.kubilaycicek.mylib.converter;

import com.kubilaycicek.mylib.dto.AuthorDto;
import com.kubilaycicek.mylib.entity.Author;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AuthorConverterImpl implements AuthorConverter {

    private final ModelMapper modelMapper;

    @Override
    public AuthorDto convertToAuthorDTO(Author author) {
        if (author == null)
            return null;
        return modelMapper.map(author, AuthorDto.class);
    }

    @Override
    public Author convertToAuthor(AuthorDto authorDto) {
        if (authorDto == null)
            return null;
        return modelMapper.map(authorDto, Author.class);
    }
}
