package com.kubilaycicek.mylib.repository;

import com.kubilaycicek.mylib.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findFirstById(long id);
}
