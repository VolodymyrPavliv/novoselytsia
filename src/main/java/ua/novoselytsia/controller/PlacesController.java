package ua.novoselytsia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/places")
public class PlacesController {
    @GetMapping
    public String showPlacesPage() {
        return "places";
    }
}
