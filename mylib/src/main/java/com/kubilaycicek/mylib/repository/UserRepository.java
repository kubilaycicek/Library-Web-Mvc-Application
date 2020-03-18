package com.kubilaycicek.mylib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kubilaycicek.mylib.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
