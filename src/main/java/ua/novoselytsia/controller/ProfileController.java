package ua.novoselytsia.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.novoselytsia.entities.Post;
import ua.novoselytsia.entities.User;
import ua.novoselytsia.security.CustomerDetails;
import ua.novoselytsia.service.PostService;
import ua.novoselytsia.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    private final UserService userService;
    private final PostService postService;

    public ProfileController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping
    public String showProfile(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomerDetails customerDetails = (CustomerDetails) principal;
        User user = userService.getById(customerDetails.getUserId());
        model.addAttribute("user", user);
        model.addAttribute("userName", user.getName());
        model.addAttribute("posts",postService.getByUserId(user.getId()));
        return "profile/profile";
    }

    @GetMapping("/edit/{id}")
    public String profileEditForm(@PathVariable Long id,Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "/profile/edit_profile";
    }

    @PostMapping("/edit/{id}")
    public String profileEdit(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                              @RequestParam("age") int age, @PathVariable Long id,
                              Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomerDetails customerDetails = (CustomerDetails) principal;
        User currentUser = userService.getById(customerDetails.getUserId());

        if(user==currentUser || currentUser.getRoles().stream()
                .anyMatch(role -> role.getName().equals("MANAGER"))) {
            userService.save(user);
        }
        return "redirect:/profile";
    }

    @GetMapping("/post/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.delete(postService.getById(id));
        return "redirect:/profile";
    }

    @GetMapping("/post/edit/{id}")
    public String editPostForm(@PathVariable Long id, Model model) {
        Post post = postService.getById(id);
        model.addAttribute("post", post);
        model.addAttribute("title", post.getTitle());
        return "/profile/edit_post";
    }

    @PostMapping("/post/edit/{id}")
    public String editPost(@RequestParam(value = "title") String title, @RequestParam(value = "text")String text,
                           Model model, @PathVariable Long id) {
        Post post = postService.getById(id);
        post.setTitle(title);
        post.setText(text);
        post.setLastModified(LocalDateTime.now());

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomerDetails customerDetails = (CustomerDetails) principal;
        User currentUser = userService.getById(customerDetails.getUserId());

        if(post.getUser() == currentUser || currentUser.getRoles().stream()
                .anyMatch(role -> role.getName().equals("MANAGER"))) {
            postService.save(post);
        }
        return "redirect:/profile";
    }

}
