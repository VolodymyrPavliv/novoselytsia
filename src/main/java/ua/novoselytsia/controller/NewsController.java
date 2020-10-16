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

@Controller
@RequestMapping("/news")
public class NewsController {
    private final PostService postService;
    private final UserService userService;

    public NewsController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
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
    public String addPost(@ModelAttribute("newPost") Post post){
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
