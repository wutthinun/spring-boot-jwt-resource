package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "agm_user")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "version")
    private long version;
    @Basic
    @Column(name = "account_expired")
    private boolean accountExpired;
    @Basic
    @Column(name = "account_locked")
    private boolean accountLocked;
    @Basic
    @Column(name = "enabled")
    private boolean enabled;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "password_expired")
    private boolean passwordExpired;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "username")
    private String username;
}
