package com.mikidevs.sparkscene.user;

import java.util.Map;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mikidevs.sparkscene.shared.FormUtil;
import com.mikidevs.sparkscene.user.model.UserRegisterForm;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import jakarta.validation.Valid;

@Controller
public class UserController {
    
    @HxRequest
    @PostMapping(path = "/users", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String create(@Valid @ModelAttribute UserRegisterForm userRegistration, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("userRegistration", userRegistration);
            model.addAttribute("errors", FormUtil.getErrorMap(bindingResult));
            return "public/register";
        }
        return "public/login";
    }
}
