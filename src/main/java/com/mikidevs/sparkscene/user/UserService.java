package com.mikidevs.sparkscene.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mikidevs.sparkscene.user.model.User;
import com.mikidevs.sparkscene.user.model.UserRegisterForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public void save(UserRegisterForm userForm) {
        var password = passwordEncoder.encode(userForm.password());
        var appUser = new User(userForm, password);
        userRepository.save(appUser);
    }

    public User get() {
        return userRepository.getReferenceById(Long.valueOf(0));
    }
}
