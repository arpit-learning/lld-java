package com.example.projects.parkingLotSystemDesign.repositories;

import com.example.projects.parkingLotSystemDesign.exceptions.EntityNotFoundException;
import com.example.projects.parkingLotSystemDesign.models.ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLotRepository implements Repository<ParkingLot> {
    // IN-MEMORY db
    private static int idCounter = 1;
    public HashMap<Integer, ParkingLot> items = new HashMap<>();

    @Override
    public ParkingLot save(ParkingLot entity) {
        if (!items.containsKey(entity.getId())) {
            entity.setId(idCounter++);
        }
        items.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public ParkingLot findById(int id) {
        if (!items.containsKey(id)) {
            throw new EntityNotFoundException("Entity of type " + ParkingLot.class.getSimpleName() + " with id " + id + " not found.");
        }
        return items.get(id);
    }

    @Override
    public ParkingLot delete(int id) {
        return items.remove(id);
    }

    @Override
    public List<ParkingLot> getAll() {
        return new ArrayList<>(items.values());
    }
}
