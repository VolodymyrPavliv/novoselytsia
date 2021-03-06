package ua.novoselytsia.dao;

import ua.novoselytsia.entities.Place;

import java.util.List;

public interface PlaceDAO {
    List<Place> getAll();
    List<Place> getByName(String name);
    Place getById(Long id);
    void save(Place place);
    void delete(Place place);
}
