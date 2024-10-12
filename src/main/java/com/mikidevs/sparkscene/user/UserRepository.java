package com.mikidevs.sparkscene.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikidevs.sparkscene.user.model.ApplicationUser;

public interface UserRepository extends JpaRepository<ApplicationUser, Long>{
    ApplicationUser findByEmail(String email);
}
