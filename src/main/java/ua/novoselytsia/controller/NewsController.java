package ua.novoselytsia.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.novoselytsia.entities.Post;
import ua.novoselytsia.entities.User;
import ua.novoselytsia.security.CustomerDetails;
import ua.novoselytsia.service.PostService;
import ua.novoselytsia.service.UserService;
import ua.novoselytsia.validation.PostValidator;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/news")
@PropertySource({"classpath:path.properties"})
public class NewsController {
    private final PostService postService;
    private final UserService userService;
    private final PostValidator postValidator;
    private final Environment environment;

    private final int MAX_SIZE = 200000;
    @Value("${upload.path}")
    private String upload;

    public NewsController(PostService postService, UserService userService, PostValidator postValidator, Environment environment) {
        this.postService = postService;
        this.userService = userService;
        this.postValidator = postValidator;
        this.environment = environment;
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
    public String addPost(@ModelAttribute("newPost") Post post, Errors errors,
                          @RequestParam("file")MultipartFile file, Model model) throws IOException {
        postValidator.validate(post, errors);
        if(errors.hasErrors()){
            return "news/add_post";
        }

        if(file.getSize()>MAX_SIZE) {
            model.addAttribute("fileError", environment.getProperty("error.file"));
            return "news/add_post";
        }

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomerDetails customerDetails = (CustomerDetails) principal;
        User user = userService.getById(customerDetails.getUserId());
        post.setUser(user);

        LocalDateTime dateTime = LocalDateTime.now();
        post.setPublicationDate(dateTime);

        if(file.getSize()>0) {
            file.transferTo(new File(upload + file.getOriginalFilename()));
            post.setFilename(file.getOriginalFilename());
        }

        postService.save(post);

        return "redirect:/news";
    }

}
