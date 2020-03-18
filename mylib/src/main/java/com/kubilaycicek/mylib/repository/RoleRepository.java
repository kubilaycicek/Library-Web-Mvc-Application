package com.kubilaycicek.mylib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kubilaycicek.mylib.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
