package com.example.projects.parkingLotSystemDesign.repositories;

import com.example.projects.parkingLotSystemDesign.exceptions.EntityNotFoundException;
import com.example.projects.parkingLotSystemDesign.models.Bill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BillRepository implements Repository<Bill> {
    // IN-MEMORY db
    private static int idCounter = 1;
    public HashMap<Integer, Bill> items = new HashMap<>();

    @Override
    public Bill save(Bill entity) {
        if (!items.containsKey(entity.getId())) {
            entity.setId(idCounter++);
        }
        items.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Bill findById(int id) {
        if (!items.containsKey(id)) {
            throw new EntityNotFoundException("Entity of type " + Bill.class.getSimpleName() + " with id " + id + " not found.");
        }
        return items.get(id);
    }

    @Override
    public Bill delete(int id) {
        return items.remove(id);
    }

    @Override
    public List<Bill> getAll() {
        return new ArrayList<>(items.values());
    }
}
