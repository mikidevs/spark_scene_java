package com.mikidevs.sparkscene.user.model;

import java.util.Collection;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record ApplicationUser(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id,
    String name, 
    String email,
    String password,
    Collection<String> roles
) {
    public static ApplicationUser fromForm(UserRegisterForm form, String password) {
        return new ApplicationUser(0, form.userName(), form.email(), password, List.of("ROLE_USER"));
    }
}
