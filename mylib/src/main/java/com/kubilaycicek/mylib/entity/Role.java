package com.kubilaycicek.mylib.entity;

import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.ToString;

@Table
@Entity
@Data
@ToString
public class Role extends BaseEntity {
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(fetch = FetchType.LAZY,
            targetEntity = User.class, cascade = CascadeType.ALL, mappedBy = "role")
    private List<User> users;
}
