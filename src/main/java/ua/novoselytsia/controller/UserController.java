package ua.novoselytsia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.novoselytsia.entities.User;
import ua.novoselytsia.service.UserService;

@Controller
@RequestMapping("/management/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUserList(@RequestParam(value = "lastName", defaultValue = "") String lastName, Model model) {
        model.addAttribute("users", userService.getByLastName(lastName));
        return "management/users";
    }

    @PostMapping("/{id}")
    public String changeStatus(@PathVariable Long id) {
        User user = userService.getById(id);
        userService.changeRole(user);
        return "redirect:/management/users";

    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/management/users";
    }
}
