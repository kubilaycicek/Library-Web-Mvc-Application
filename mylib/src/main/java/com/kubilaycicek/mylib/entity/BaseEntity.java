package com.kubilaycicek.mylib.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
}
