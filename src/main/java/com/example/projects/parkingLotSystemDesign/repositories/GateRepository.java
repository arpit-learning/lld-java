package com.example.projects.parkingLotSystemDesign.repositories;

import com.example.projects.parkingLotSystemDesign.exceptions.EntityNotFoundException;
import com.example.projects.parkingLotSystemDesign.models.Gate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GateRepository implements Repository<Gate> {
    // IN-MEMORY db
    private static int idCounter = 1;
    public HashMap<Integer, Gate> items = new HashMap<>();

    @Override
    public Gate save(Gate entity) {
        if (!items.containsKey(entity.getId())) {
            entity.setId(idCounter++);
        }
        items.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Gate findById(int id) {
        if (!items.containsKey(id)) {
            throw new EntityNotFoundException("Entity of type " + Gate.class.getSimpleName() + " with id " + id + " not found.");
        }
        return items.get(id);
    }

    @Override
    public Gate delete(int id) {
        return items.remove(id);
    }

    @Override
    public List<Gate> getAll() {
        return new ArrayList<>(items.values());
    }
}
