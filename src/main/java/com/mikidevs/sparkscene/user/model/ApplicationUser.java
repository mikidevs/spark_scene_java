package com.mikidevs.sparkscene.user.model;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record ApplicationUser(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id,
    String name, 
    @NaturalId String email,
    String password
) {
    public static ApplicationUser fromForm(UserRegisterForm form, String password) {
        return new ApplicationUser(Long.valueOf(0), form.userName(), form.email(), password);
    }
}
