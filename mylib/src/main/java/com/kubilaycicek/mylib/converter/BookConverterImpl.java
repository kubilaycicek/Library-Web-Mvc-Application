package com.kubilaycicek.mylib.converter;

import com.kubilaycicek.mylib.dto.BookDto;
import com.kubilaycicek.mylib.entity.Book;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class BookConverterImpl implements BookConverter {

    private final ModelMapper modelMapper;
    private final PublisherConverter publisherConverter;
    private final AuthorConverter authorConverter;


    private void addSkipFieldsForConvertToDto() {
        TypeMap<BookDto, Book> typeMap = modelMapper.getTypeMap(BookDto.class, Book.class);
        if (typeMap == null) {
            modelMapper.addMappings(new PropertyMap<BookDto, Book>() {
                @Override
                protected void configure() {
                    skip(destination.getAuthor());
                    skip(destination.getPublisher());
                }
            });
        }
    }

    private void addSkipFieldsForConvertToDomain() {
        TypeMap<Book, BookDto> typeMap = modelMapper.getTypeMap(Book.class, BookDto.class);
        if (typeMap == null) {
            modelMapper.addMappings(new PropertyMap<Book, BookDto>() {
                @Override
                protected void configure() {
                    skip(destination.getAuthorDto());
                    skip(destination.getPublisherDto());
                }
            });
        }
    }

    @Override
    public BookDto convertToBookDTO(Book book) {
        if (book == null) {
            return null;
        }
        addSkipFieldsForConvertToDto();

        BookDto bookDTO = modelMapper.map(book, BookDto.class);
        if (book.getAuthor() != null) {
            bookDTO.setAuthorDto(authorConverter.convertToAuthorDTO(book.getAuthor()));
        }
        if (book.getPublisher() != null) {
            bookDTO.setPublisherDto(publisherConverter.convertToPublisherDTO(book.getPublisher()));
        }

        return bookDTO;
    }

    @Override
    public Book convertToBook(BookDto bookDTO) {
        if (bookDTO == null) {
            return null;
        }
        Book book = modelMapper.map(bookDTO, Book.class);
        addSkipFieldsForConvertToDomain();

        if (bookDTO.getAuthorDto() != null) {
            book.setAuthor(authorConverter.convertToAuthor(bookDTO.getAuthorDto()));
        }
        if (bookDTO.getPublisherDto() != null) {
            book.setPublisher(publisherConverter.convertToPublisher(bookDTO.getPublisherDto()));
        }
        return book;
    }

}
