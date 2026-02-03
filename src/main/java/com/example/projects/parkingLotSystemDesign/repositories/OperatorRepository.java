package com.example.projects.parkingLotSystemDesign.repositories;

import com.example.projects.parkingLotSystemDesign.exceptions.EntityNotFoundException;
import com.example.projects.parkingLotSystemDesign.models.Operator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OperatorRepository implements Repository<Operator> {
    // IN-MEMORY db
    private static int idCounter = 1;
    public HashMap<Integer, Operator> items = new HashMap<>();

    @Override
    public Operator save(Operator entity) {
        if (!items.containsKey(entity.getId())) {
            entity.setId(idCounter++);
        }
        items.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Operator findById(int id) {
        if (!items.containsKey(id)) {
            throw new EntityNotFoundException("Entity of type " + Operator.class.getSimpleName() + " with id " + id + " not found.");
        }
        return items.get(id);
    }

    @Override
    public Operator delete(int id) {
        return items.remove(id);
    }

    @Override
    public List<Operator> getAll() {
        return new ArrayList<>(items.values());
    }
}
