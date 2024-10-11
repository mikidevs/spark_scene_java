package com.mikidevs.sparkscene.common;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mikidevs.sparkscene.user.model.UserRegisterForm;

@Controller
public class PublicController {

    @GetMapping(path = "")
    public String landing() {
        return "public/landing";
    }

    @GetMapping(path = "/login")
    public String login() {
        return "public/login";
    }

    @GetMapping(path = "/register")
    public String register(Model model) {
        model.addAttribute("userRegistration", UserRegisterForm.empty());
        model.addAttribute("errors", Map.of());
        return "public/register";
    }
}
