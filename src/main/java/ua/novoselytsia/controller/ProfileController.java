package ua.novoselytsia.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ua.novoselytsia.entities.Post;
import ua.novoselytsia.entities.User;
import ua.novoselytsia.security.CustomerDetails;
import ua.novoselytsia.service.PostService;
import ua.novoselytsia.service.UserService;
import ua.novoselytsia.validation.PostValidator;
import ua.novoselytsia.validation.UserValidator;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    private final UserService userService;
    private final PostService postService;
    private final PostValidator postValidator;
    private final UserValidator userValidator;

    public ProfileController(UserService userService, PostService postService, PostValidator postValidator, UserValidator userValidator) {
        this.userService = userService;
        this.postService = postService;
        this.postValidator = postValidator;
        this.userValidator = userValidator;
    }

    @GetMapping
    public String showProfile(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomerDetails customerDetails = (CustomerDetails) principal;
        User user = userService.getById(customerDetails.getUserId());
        model.addAttribute("user", user);
        model.addAttribute("userName", user.getName());
        return "profile/profile";
    }

    @GetMapping("/edit/{id}")
    public String profileEditForm(@PathVariable Long id,Model model, @ModelAttribute("newUser") User newUser) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "profile/edit_profile";
    }

    @PostMapping("/edit/{id}")
    public String profileEdit(@ModelAttribute("newUser") User newUser, Errors errors, @PathVariable Long id,
                              Model model) {
        User user = userService.getById(id);

        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setAge(newUser.getAge());

        userValidator.validate(user, errors);
        if(errors.hasErrors()) {
            model.addAttribute("user", user);
            return "profile/edit_profile";
        }
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            CustomerDetails customerDetails = (CustomerDetails) principal;
            User currentUser = userService.getById(customerDetails.getUserId());

            if (user == currentUser || currentUser.getRoles().stream()
                    .anyMatch(role -> role.getName().equals("MANAGER"))) {
                userService.save(user);
            }
            return "redirect:/profile";

    }

    @GetMapping("/news/{id}")
    public String showPosts(Model model, @PathVariable Long id,
                            @RequestParam(value = "title",defaultValue = "") String title) {
        model.addAttribute("posts",postService.getByUserIdAndTitle(id, title));
        if(!title.isEmpty()) {
            model.addAttribute("title", title);
        }
        return "profile/news";
    }

    @GetMapping("/news/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomerDetails customerDetails = (CustomerDetails) principal;
        User currentUser = userService.getById(customerDetails.getUserId());
        Post post = postService.getById(id);
        if(post.getUser() == currentUser || currentUser.getRoles().stream()
                .anyMatch(role -> role.getName().equals("MANAGER"))) {
            postService.delete(post);
        }
        return "redirect:/profile/news/"+currentUser.getId();
    }

    @GetMapping("/news/edit/{id}")
    public String editPostForm(@PathVariable Long id, Model model, @ModelAttribute("newPost") Post newPost) {
        Post post = postService.getById(id);
        model.addAttribute("post", post);
        model.addAttribute("title", post.getTitle());
        return "/profile/edit_post";
    }

    @PostMapping("/news/edit/{id}")
    public String editPost(@ModelAttribute("newPost") Post newPost, Errors errors,
                           Model model, @PathVariable Long id) {
        Post post = postService.getById(id);
        post.setTitle(newPost.getTitle());
        post.setText(newPost.getText());

        postValidator.validate(post, errors);
        if(errors.hasErrors()) {
            model.addAttribute("post",post);
            return "management/edit_post";
        }

        post.setLastModified(LocalDateTime.now());

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomerDetails customerDetails = (CustomerDetails) principal;
        User currentUser = userService.getById(customerDetails.getUserId());

        if(post.getUser() == currentUser || currentUser.getRoles().stream()
                .anyMatch(role -> role.getName().equals("MANAGER"))) {
            postService.save(post);
        }
        return "redirect:/profile/news/"+currentUser.getId();
    }
}
