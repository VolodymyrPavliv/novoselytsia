package ua.novoselytsia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.novoselytsia.entities.Post;
import ua.novoselytsia.service.PostService;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/management")
public class ManagementController {
    private final PostService postService;

    public ManagementController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String showManagementPage() {
        return "management/management";
    }

    @GetMapping("/news")
    public String showManagementNews(Model model, @RequestParam(value = "title", defaultValue = "") String title) {
            model.addAttribute("news", postService.getByTitle(title));
            if(!title.isEmpty()) {
                model.addAttribute("title", title);
            }
        return "management/news";
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

        postService.save(post);
        return "redirect:/profile";
    }

}
