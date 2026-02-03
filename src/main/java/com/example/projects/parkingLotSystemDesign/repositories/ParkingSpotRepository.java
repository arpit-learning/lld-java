package com.example.projects.parkingLotSystemDesign.repositories;

import com.example.projects.parkingLotSystemDesign.exceptions.EntityNotFoundException;
import com.example.projects.parkingLotSystemDesign.models.ParkingSpot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingSpotRepository implements Repository<ParkingSpot> {
    // IN-MEMORY db
    private static int idCounter = 1;
    public HashMap<Integer, ParkingSpot> items = new HashMap<>();

    @Override
    public ParkingSpot save(ParkingSpot entity) {
        if (!items.containsKey(entity.getId())) {
            entity.setId(idCounter++);
        }
        items.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public ParkingSpot findById(int id) {
        if (!items.containsKey(id)) {
            throw new EntityNotFoundException("Entity of type " + ParkingSpot.class.getSimpleName() + " with id " + id + " not found.");
        }
        return items.get(id);
    }

    @Override
    public ParkingSpot delete(int id) {
        return items.remove(id);
    }

    @Override
    public List<ParkingSpot> getAll() {
        return new ArrayList<>(items.values());
    }
}
