package com.mikidevs.sparkscene.common;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Landing {
    @GetMapping(path = "", produces = MediaType.TEXT_HTML_VALUE)
    public String landing() {
        return "public/landing";
    }
}
