package pl.akai.bookcrossing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Rest {

    @GetMapping("/login")
    public String greeting() {
        return "index";
    }

}