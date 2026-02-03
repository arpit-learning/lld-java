package com.example.projects.parkingLotSystemDesign.repositories;

import com.example.projects.parkingLotSystemDesign.exceptions.EntityNotFoundException;
import com.example.projects.parkingLotSystemDesign.models.ParkingFloor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingFloorRepository implements Repository<ParkingFloor> {
    // IN-MEMORY db
    private static int idCounter = 1;
    public HashMap<Integer, ParkingFloor> items = new HashMap<>();

    @Override
    public ParkingFloor save(ParkingFloor entity) {
        if (!items.containsKey(entity.getId())) {
            entity.setId(idCounter++);
        }
        items.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public ParkingFloor findById(int id) {
        if (!items.containsKey(id)) {
            throw new EntityNotFoundException("Entity of type " + ParkingFloor.class.getSimpleName() + " with id " + id + " not found.");
        }
        return items.get(id);
    }

    @Override
    public ParkingFloor delete(int id) {
        return items.remove(id);
    }

    @Override
    public List<ParkingFloor> getAll() {
        return new ArrayList<>(items.values());
    }
}
