package com.mikidevs.sparkscene.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mikidevs.sparkscene.user.model.User;
import com.mikidevs.sparkscene.user.model.UserRegisterForm;

public class UserService {
    
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(UserRegisterForm userForm) {
        var password = passwordEncoder.encode(userForm.password());
        var appUser = User.fromForm(userForm, password);
        userRepository.save(appUser);
    }
}
