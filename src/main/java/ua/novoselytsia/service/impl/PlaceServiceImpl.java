package ua.novoselytsia.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.novoselytsia.dao.PlaceDAO;
import ua.novoselytsia.entities.Place;
import ua.novoselytsia.service.PlaceService;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {
    private final PlaceDAO placeDAO;

    public PlaceServiceImpl(PlaceDAO placeDAO) {
        this.placeDAO = placeDAO;
    }

    @Override
    @Transactional
    public List<Place> getAll() {
        return placeDAO.getAll();
    }

    @Override
    @Transactional
    public List<Place> getByName(String name) {
        if(name.isEmpty())
            return getAll();
        return placeDAO.getByName(name);

    }
}
