package Myproject.recomandplace.dto;

import Myproject.recomandplace.domain.Restaurant;
import lombok.Getter;


@Getter
public class RestaurantResponseDto {

    private String name;
    private String location;
    private String description;

   public RestaurantResponseDto(Restaurant restaurant) {
       this.name = restaurant.getName();
       this.location = restaurant.getLocation();
       this.description = restaurant.getDescription();
   }
}
