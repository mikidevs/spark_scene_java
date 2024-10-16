package com.mikidevs.sparkscene.user.model;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "application_user")
public record User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id,
    String name, 
    @NaturalId String email,
    String password
) {
    public static User fromForm(UserRegisterForm form, String password) {
        return new User(Long.valueOf(0), form.userName(), form.email(), password);
    }
}
