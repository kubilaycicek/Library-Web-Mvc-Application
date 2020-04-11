package com.kubilaycicek.mylib.service;

import java.util.List;

import com.kubilaycicek.mylib.dto.BookDto;
import com.kubilaycicek.mylib.entity.Book;;

public interface BookService {
	BookDto addBook(BookDto bookDto);
	BookDto updateBook(BookDto bookDto);
	List<Book> getAllBook();
	BookDto getByBookID(long bookID);
	void removeByBookID(long bookID);
}
