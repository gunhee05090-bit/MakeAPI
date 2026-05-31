package Myproject.recomandplace.dto;

import Myproject.recomandplace.domain.Restaurant;
import jakarta.persistence.Column;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
public class RestaurantResponseDto {

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    @Autowired
   public RestaurantResponseDto(Restaurant restaurant) {
       this.name = restaurant.getName();
       this.location = restaurant.getLocation();
       this.description = restaurant.getDescription();
   }

}
