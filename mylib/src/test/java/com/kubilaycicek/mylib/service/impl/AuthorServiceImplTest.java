package com.kubilaycicek.mylib.service.impl;

import com.kubilaycicek.mylib.converter.AuthorConverter;
import com.kubilaycicek.mylib.dto.AuthorDto;
import com.kubilaycicek.mylib.entity.Author;
import com.kubilaycicek.mylib.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorServiceImplTest {
    @InjectMocks
    private AuthorServiceImpl authorService;
    @Mock
    private AuthorRepository authorRepository;
    @Mock
    private AuthorConverter authorConverter;

    @Test
    void addAuthor() {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(1);
        authorDto.setName("Test-Name");
        authorDto.setDescription("Test-Description");

        Author authorMock = mock(Author.class);

        lenient().when(authorMock.getId()).thenReturn(1L);
        lenient().when(authorConverter.convertToAuthor(ArgumentMatchers.any(AuthorDto.class))).thenReturn(authorMock);
        lenient().when(authorRepository.save(ArgumentMatchers.any(Author.class))).thenReturn(authorMock);
        lenient().when(authorConverter.convertToAuthorDTO(ArgumentMatchers.any(Author.class))).thenReturn(authorDto);

        AuthorDto result = authorService.addAuthor(authorDto);

        assertEquals(result.getName(), authorDto.getName());
        assertEquals(result.getId(), 1L);
    }

    @Test
    void updateAuthor() {
    }

    @Test
    void getAllAuthor() {
    }

    @Test
    void getByAuthorID() {
    }

    @Test
    void removeByAuthorID() {
    }
}