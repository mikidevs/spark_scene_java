package com.mikidevs.sparkscene.user.model;

import com.mikidevs.sparkscene.user.validations.FieldsMatch;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@FieldsMatch(firstField = "password", secondField = "confirmPassword", message = "Passwords must match")
public record UserRegisterForm(

    @NotBlank(message = "User name is required")
    @Size(min = 4, message = "User name must be at least 4 characters long")
    String userName, 

    @NotBlank(message = "Email is required")
    @Email(message = "Email is invalid")
    String email,

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    String password,

    @NotBlank(message = "Confrim password is required")
    @Size(min = 8, message = "Confirm Password must be at least 8 characters long")
    String confirmPassword
) {
    public static UserRegisterForm empty() {
        return new UserRegisterForm("", "", "", "");
    }
}
