package ua.novoselytsia.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.novoselytsia.entities.Post;
import ua.novoselytsia.entities.User;
import ua.novoselytsia.security.CustomerDetails;
import ua.novoselytsia.service.PostService;

@Controller
@RequestMapping("/news")
public class NewsController {
    private PostService postService;

    public NewsController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String showNews(Model model) {
        model.addAttribute("news", postService.getAll());
        return "news";
    }

    @GetMapping("/add")
    public String newPostForm(@ModelAttribute("newPost") Post post) {
        return "add_post";
    }

    @PostMapping("/add")
    public String addHotel(@ModelAttribute("post") Post post, Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User) principal;
        post.setUser(user);
        postService.save(post);
        return "redirect:/news";
    }
}
