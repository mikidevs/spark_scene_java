package com.mikidevs.sparkscene.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginViewController {

    @GetMapping(path = "/login")
    public String login() {
        return "public/login";
    }

}
