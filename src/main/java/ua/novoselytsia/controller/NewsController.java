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

import java.time.LocalDateTime;

@Controller
@RequestMapping("/news")
public class NewsController {
    private final PostService postService;
    private final UserService userService;
    private final PostValidator postValidator;

    public NewsController(PostService postService, UserService userService, PostValidator postValidator) {
        this.postService = postService;
        this.userService = userService;
        this.postValidator = postValidator;
    }

    @GetMapping
    public String showNews(Model model, @RequestParam(value = "title", defaultValue = "") String title) {
         model.addAttribute("news", postService.getByTitle(title));
         if(!title.isEmpty()) {
             model.addAttribute("title", title);
         }
        return "news/news";
    }

    @GetMapping("/add")
    public String newPostForm(@ModelAttribute("newPost") Post post) {
        return "news/add_post";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute("newPost") Post post, Errors errors){
        postValidator.validate(post, errors);
        if(errors.hasErrors()){
            return "news/add_post";
        }

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomerDetails customerDetails = (CustomerDetails) principal;
        User user = userService.getById(customerDetails.getUserId());
        post.setUser(user);

        LocalDateTime dateTime = LocalDateTime.now();
        post.setPublicationDate(dateTime);

        postService.save(post);

        return "redirect:/news";
    }

}
