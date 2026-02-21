package dev.arpit.BookMyShow.repositories;

import dev.arpit.BookMyShow.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
