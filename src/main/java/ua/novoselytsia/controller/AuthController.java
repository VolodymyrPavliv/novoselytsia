package ua.novoselytsia.controller;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.novoselytsia.entities.User;
import ua.novoselytsia.service.UserService;
import ua.novoselytsia.validation.UserValidator;

@Controller
public class AuthController {
    private final Environment environment;
    private final UserService userService;
    private final UserValidator userValidator;

    public AuthController(Environment environment, UserService userService, UserValidator userValidator) {
        this.environment = environment;
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping("/login")
    public String login(String error, String logout, Model model) {
        if (error != null) {
            model.addAttribute("error", environment.getProperty("error.login"));
        }
        if (logout != null) {
            model.addAttribute("message", environment.getProperty("message.logout"));
        }
        return "login";
    }

    @GetMapping("/registration")
    public String registrationForm(@ModelAttribute("newUser") User user) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("newUser") User user, Errors errors) {
        userValidator.validate(user, errors);
        if (errors.hasErrors()) {
            return "registration";
        }
        userService.register(user);
        return "redirect:/login";
    }

}
