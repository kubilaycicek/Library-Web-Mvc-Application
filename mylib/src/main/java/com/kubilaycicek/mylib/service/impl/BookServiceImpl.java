package com.kubilaycicek.mylib.service.impl;

import com.kubilaycicek.mylib.converter.BookConverter;
import com.kubilaycicek.mylib.dto.BookDto;
import com.kubilaycicek.mylib.entity.Book;
import com.kubilaycicek.mylib.repository.AuthorRepository;
import com.kubilaycicek.mylib.repository.PublisherRepository;
import com.kubilaycicek.mylib.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.kubilaycicek.mylib.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final BookConverter bookConverter;

    @Override
    public BookDto addBook(BookDto bookDto) {
        Book book = bookRepository.save(bookConverter.convertToBook(bookDto));
        return bookConverter.convertToBookDTO(book);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        Book book = bookRepository.findFirstById(bookDto.getId());
        if (book != null) {
            book.setName(bookDto.getName());
            book.setIsbnNumber(bookDto.getIsbnNumber());
            book.setSerialName(bookDto.getSerialName());
            book.setSubname(bookDto.getSubName());
            book.setAuthor(authorRepository.findFirstById(bookDto.getAuthorDto().getId()));
            book.setPublisher(publisherRepository.findFirstById(bookDto.getPublisherDto().getId()));
        } else {
            throw new IllegalArgumentException("Author does not exist !");
        }
        return bookConverter.convertToBookDTO((bookRepository.save(book)));
    }

    @Override
    public List<Book> getAllBook() {
        ArrayList<Book> list = new ArrayList<>();
        bookRepository.findAll().iterator().forEachRemaining(book -> list.add(book));
        return list;
    }

    @Override
    public BookDto getByBookID(long bookID) {
        return bookConverter.convertToBookDTO(bookRepository.findFirstById(bookID));
    }

    @Override
    public void removeByBookID(long bookID) {
        bookRepository.deleteById(bookID);
    }
}
