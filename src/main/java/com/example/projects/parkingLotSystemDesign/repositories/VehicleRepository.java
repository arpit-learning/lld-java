package com.example.projects.parkingLotSystemDesign.repositories;

import com.example.projects.parkingLotSystemDesign.exceptions.EntityNotFoundException;
import com.example.projects.parkingLotSystemDesign.models.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VehicleRepository implements Repository<Vehicle> {
    // IN-MEMORY db
    private static int idCounter = 1;
    public HashMap<Integer, Vehicle> items = new HashMap<>();

    @Override
    public Vehicle save(Vehicle entity) {
        if (!items.containsKey(entity.getId())) {
            entity.setId(idCounter++);
        }
        items.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Vehicle findById(int id) {
        if (!items.containsKey(id)) {
            throw new EntityNotFoundException("Entity of type " + Vehicle.class.getSimpleName() + " with id " + id + " not found.");
        }
        return items.get(id);
    }

    @Override
    public Vehicle delete(int id) {
        return items.remove(id);
    }

    @Override
    public List<Vehicle> getAll() {
        return new ArrayList<>(items.values());
    }
}
