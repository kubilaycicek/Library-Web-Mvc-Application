package com.kubilaycicek.mylib.service;

import java.util.List;

import com.kubilaycicek.mylib.dto.AuthorDto;
import com.kubilaycicek.mylib.entity.Author;

public interface AuthorService {
	AuthorDto addAuthor(AuthorDto authorDto);
	AuthorDto updateAuthor(AuthorDto authorDto);
	List<Author> getAllAuthor();
	AuthorDto getByAuthorID(long authorID);
	void removeByAuthorID(long authorID);
}
