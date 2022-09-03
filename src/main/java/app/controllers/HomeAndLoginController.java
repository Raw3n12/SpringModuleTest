package app.controllers;

import app.models.Officer;
import app.repositories.ApplicationUserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeAndLoginController {


    public final ApplicationUserRepo applicationUserRepo;

    public HomeAndLoginController(ApplicationUserRepo applicationUserRepo) {
        this.applicationUserRepo = applicationUserRepo;
    }


    @GetMapping(value = {"/", "/home", "/fooldal"})
    public String getHomePage() {
        return "index";
    }

    @GetMapping(value = {"/login", "/bejelentkezes"})
    public String viewHomepage() {
        return "login";
    }

    @GetMapping(value = {"/login-error"})
    public String loginErrorPage(Model model) {
        model.addAttribute("loginError", true);

        return "login";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new Officer());
        return "register";
    }

    @PostMapping("/registrationform")
    public String processRestrain(Officer user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        applicationUserRepo.save(user);
        return "registration-success";
    }
}
