package com.kubilaycicek.mylib.entity;



import javax.persistence.*;
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
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false,targetEntity = Role.class)
    private Role role;



}
