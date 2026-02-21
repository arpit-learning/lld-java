package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.exceptions.InvalidCityIdException;
import dev.arpit.BookMyShow.models.City;

import java.util.List;

public interface CityService {
    City findById(int id) throws InvalidCityIdException;
    City save(City city);
    List<City> getAll();
}
