package ua.novoselytsia.service;


import ua.novoselytsia.entities.Place;

import java.util.List;

public interface PlaceService {
    List<Place> getAll();
    List<Place> getByName(String name);
}
