package com.kubilaycicek.mylib.converter;

import com.kubilaycicek.mylib.dto.BookDto;
import com.kubilaycicek.mylib.entity.Book;

public interface BookConverter {
    BookDto convertToBookDTO(Book book);
    Book convertToBook(BookDto bookDto);
}
