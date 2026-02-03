package com.example.projects.parkingLotSystemDesign.repositories;

import com.example.projects.parkingLotSystemDesign.models.BaseModel;

import java.util.List;

public interface Repository<T extends BaseModel> {
    public T save(T entity);

    public T findById(int id);

    public T delete(int id);

    public List<T> getAll();
}
