package com.mikidevs.sparkscene.principle;
import com.mikidevs.sparkscene.user.model.UserRegisterForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class AuthController {
    
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
