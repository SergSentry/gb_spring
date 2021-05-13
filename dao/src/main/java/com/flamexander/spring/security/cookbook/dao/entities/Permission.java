package com.flamexander.spring.security.cookbook.dao.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
