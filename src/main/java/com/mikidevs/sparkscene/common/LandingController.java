package com.mikidevs.sparkscene.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController {

    @GetMapping(path = "/")
    public String landing() {
        return "public/landing";
    }

}
