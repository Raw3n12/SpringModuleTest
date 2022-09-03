package app.controllers;
import app.models.Officer;
import app.repositories.ApplicationUserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OfficerController {


    private final ApplicationUserRepo applicationUserRepo;

    public OfficerController(ApplicationUserRepo applicationUserRepo) {
        this.applicationUserRepo = applicationUserRepo;
    }

    @GetMapping("/login")
    public String viewHomePage() {
        return "login";
    }
    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("officer", new Officer());
        return "signup";
    }
    @PostMapping("/register")
    public String processRestriction(Officer officer) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(officer.getPassword());
        officer.setPassword(encodedPassword);
        applicationUserRepo.save(officer);
        return "redirect:/login";
    }
}