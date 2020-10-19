package ua.novoselytsia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ua.novoselytsia.entities.Place;
import ua.novoselytsia.entities.Post;
import ua.novoselytsia.service.PlaceService;
import ua.novoselytsia.service.PostService;
import ua.novoselytsia.validation.PlaceValidator;
import ua.novoselytsia.validation.PostValidator;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/management")
public class ManagementController {
    private final PostService postService;
    private final PlaceService placeService;
    private final PlaceValidator placeValidator;
    private final PostValidator postValidator;

    public ManagementController(PostService postService, PlaceService placeService, PlaceValidator placeValidator, PostValidator postValidator) {
        this.postService = postService;
        this.placeService = placeService;
        this.placeValidator = placeValidator;
        this.postValidator = postValidator;
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

    @GetMapping("/news/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.delete(postService.getById(id));
        return "redirect:/management/news";
    }

    @GetMapping("/news/edit/{id}")
    public String editPostForm(@PathVariable Long id, Model model, @ModelAttribute("newPost") Post newPost) {
        Post post = postService.getById(id);

        model.addAttribute("post", post);
        model.addAttribute("title", post.getTitle());
        return "management/edit_post";
    }

    @PostMapping("/news/edit/{id}")
    public String editPost(@ModelAttribute("newPost") Post newPost,
                           Errors errors, Model model, @PathVariable Long id) {

        Post post = postService.getById(id);
        post.setTitle(newPost.getTitle());
        post.setText(newPost.getText());

        postValidator.validate(post, errors);
        if(errors.hasErrors()) {
            model.addAttribute("post",post);
            return "management/edit_post";
        }
        post.setLastModified(LocalDateTime.now());

        postService.save(post);
        return "redirect:/management/news";
    }

    @GetMapping("/places")
    public String showManagementPlaces(Model model, @RequestParam(value = "name", defaultValue = "") String name) {
        model.addAttribute("places", placeService.getByName(name));
        if(!name.isEmpty()) {
            model.addAttribute("name",name);
        }
        return "management/places";
    }

    @GetMapping("/places/add")
    public String addPlaceForm(@ModelAttribute("newPlace")Place place){
        return "management/add_place";
    }

    @PostMapping("/places/add")
    public String addPlace(@ModelAttribute("newPlace") Place place, Errors errors) {
        placeValidator.validate(place, errors);
        if(errors.hasErrors()) {
            return "management/add_place";
        }
        placeService.save(place);
        return "redirect:/management/places";
    }

    @GetMapping("/places/delete/{id}")
    public String deletePlace(@PathVariable Long id) {
        placeService.delete(placeService.getById(id));
        return "redirect:/management/places";
    }

    @GetMapping("/places/edit/{id}")
    public String editPlaceForm(@PathVariable Long id, Model model) {
        Place place = placeService.getById(id);
        model.addAttribute("place", place);
        model.addAttribute("name", place.getName());

        return "management/edit_place";
    }

    @PostMapping("/places/edit/{id}")
    public String editPlace(@ModelAttribute("place") Place place, Errors errors) {
        placeValidator.validate(place, errors);
        if(errors.hasErrors()) {
            return "management/edit_place";
        }

        placeService.save(place);
        return "redirect:/management/places";
    }
}
