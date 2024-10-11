package com.mikidevs.sparkscene.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public record User(
    @Id @GeneratedValue long id,
    String name, 
    String email,
    String password
) {
    public static User fromForm(UserRegisterForm form) {
        return new User(0, form.userName(), form.email(), form.password());
    }
}
