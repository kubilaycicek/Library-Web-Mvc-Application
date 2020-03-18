package com.kubilaycicek.mylib.repository;

import com.kubilaycicek.mylib.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Publisher findFirstById(long id);
}
