package dev.arpit.BookMyShow.repositories;

import org.springframework.stereotype.Repository;

import dev.arpit.BookMyShow.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
}
