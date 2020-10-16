package ua.novoselytsia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.novoselytsia.service.PlaceService;

@Controller
@RequestMapping("/places")
public class PlacesController {
    private final PlaceService placeService;

    public PlacesController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public String showPlacesPage(Model model, @RequestParam(name = "name",required = false) String name) {
        model.addAttribute("name",name);
        model.addAttribute("places", placeService.getByName(name));
        return "places";
    }
}
