package Myproject.recomandplace.repository;

import Myproject.recomandplace.domain.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository {

    Restaurant save(Restaurant restaurant);
    Optional<Restaurant> findById(Long id);
    Optional<Restaurant> findByName(String name);
    Optional<Restaurant> findByLocation(String location);
    List<Restaurant> findAll();

}
