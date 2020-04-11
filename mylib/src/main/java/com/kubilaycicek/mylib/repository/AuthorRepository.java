package com.kubilaycicek.mylib.repository;

import com.kubilaycicek.mylib.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	Author findFirstById(long id);
}
