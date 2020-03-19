package com.kubilaycicek.mylib.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table
public class User extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @Column(columnDefinition = "TINYINT", length = 1)
    private Boolean isManager;

}
