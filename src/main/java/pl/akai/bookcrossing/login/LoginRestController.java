package pl.akai.bookcrossing.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginRestController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
