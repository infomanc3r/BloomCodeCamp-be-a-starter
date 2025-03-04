package com.hcc.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *  This class represents a User entity. The class implements Spring Security's UserDetails interface, allowing it to
 *  be used for authentication through Spring.
 *  The class is annotated with JPA annotations to allow it to be mapped to the database.
 */

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private LocalDate cohortStartDate;
//    private List<Authority> authorities;

    public User(String username, String password, LocalDate cohortStartDate) {
        this.username = username;
        this.password = password;
        this.cohortStartDate = cohortStartDate;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() { return username; }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public LocalDate getCohortStartDate() { return cohortStartDate; }

    public void setCohortStartDate(LocalDate cohortStartDate) { this.cohortStartDate = cohortStartDate; }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new Authority("role_student"));
        return roles;
    }

}
