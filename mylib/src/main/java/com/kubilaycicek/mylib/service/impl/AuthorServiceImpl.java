package com.kubilaycicek.mylib.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.kubilaycicek.mylib.converter.AuthorConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.kubilaycicek.mylib.dto.AuthorDto;
import com.kubilaycicek.mylib.entity.Author;
import com.kubilaycicek.mylib.repository.AuthorRepository;
import com.kubilaycicek.mylib.service.AuthorService;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorConverter authorConverter;

    @Override
    public AuthorDto addAuthor(AuthorDto authorDto) {
        Author author = authorRepository.save(authorConverter.convertToAuthor(authorDto));


        return authorConverter.convertToAuthorDTO(author);
    }

    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto) {
        Author author = authorRepository.findFirstById(authorDto.getId());
        if (author != null) {
            author.setName(authorDto.getName());
            author.setDescription(authorDto.getDescription());
        } else {
            throw new IllegalArgumentException("Author does not exist !");
        }

        return authorConverter.convertToAuthorDTO(authorRepository.save(author));
    }

    @Override
    public List<Author> getAllAuthor() {
        ArrayList<Author> list = new ArrayList<Author>();
        authorRepository.findAll().iterator().forEachRemaining(author -> list.add(author));
        return list;
    }

    @Override
    public AuthorDto getByAuthorID(long authorID) {
        return authorConverter.convertToAuthorDTO(authorRepository.findFirstById(authorID));
    }

    @Override
    public void removeByAuthorID(long authorID) {
        authorRepository.deleteById(authorID);
    }
}
