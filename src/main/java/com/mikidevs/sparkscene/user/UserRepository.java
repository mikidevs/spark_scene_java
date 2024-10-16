package com.mikidevs.sparkscene.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikidevs.sparkscene.user.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
