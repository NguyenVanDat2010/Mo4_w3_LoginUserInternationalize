package demo.controller;

import demo.model.Login;
import demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {

    @GetMapping("/login")
    public String login(@ModelAttribute("login") Login login) {
        return "login";
    }

    @PostMapping("/login")
    public String dologin(@ModelAttribute("login") Login login, Model model) {
        User user = new User();
        user.setUserName(login.getUsername());
        model.addAttribute("user", user);
        return "redirect:dashboard";
    }
}
