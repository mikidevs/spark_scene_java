package com.mikidevs.sparkscene.user;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mikidevs.sparkscene.user.model.UserRegisterForm;

@Controller
public class RegisterViewController {

    @GetMapping(path = "/register")
    public String registerView(Model model) {
        model.addAttribute("userRegistration", UserRegisterForm.empty());
        model.addAttribute("errors", Map.of());
        return "public/register";
    }
    
}
