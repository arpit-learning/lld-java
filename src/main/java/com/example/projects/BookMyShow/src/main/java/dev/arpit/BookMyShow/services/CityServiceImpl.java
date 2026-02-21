package dev.arpit.BookMyShow.services;

import dev.arpit.BookMyShow.dtos.ResponseCode;
import dev.arpit.BookMyShow.exceptions.InvalidCityIdException;
import dev.arpit.BookMyShow.models.City;
import dev.arpit.BookMyShow.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City findById(int id) throws InvalidCityIdException {
        return cityRepository.findById(id).orElseThrow(() -> new InvalidCityIdException("City with id " + id + " not found.", ResponseCode.ER_400, "Unable to find city. Please try again later."));
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }
}
