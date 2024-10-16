package com.mikidevs.sparkscene.user.model;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "application_user")
public class User {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String name;
    private @NaturalId String email;
    private String password;

    public User(String userName, String email, String password) {
        this.name = userName;
        this.email = email;
        this.password = password;
    }

    public User(UserRegisterForm form, String password) {
        this.name = form.userName();
        this.email = form.email();
        this.password = password;
    }

}
