package ua.novoselytsia.service;


import ua.novoselytsia.entities.Place;

import java.util.List;

public interface PlaceService {
    List<Place> getAll();
    List<Place> getByName(String name);
    Place getById(Long id);
    void delete(Place place);
    void save(Place place);
}
