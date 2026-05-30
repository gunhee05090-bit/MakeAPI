package Myproject.recomandplace.repository;

import Myproject.recomandplace.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SDJPlaceRepository extends JpaRepository<Restaurant, Long>, PlaceRepository {


    // JPQL "SELECT m FROM Restaurant m WHERE m.name = ?"
    @Override
    Optional<Restaurant> findByName(String name);

    @Override
    Optional<Restaurant> findByLocation(String location);

}
