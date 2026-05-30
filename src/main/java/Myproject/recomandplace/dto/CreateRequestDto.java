package Myproject.recomandplace.dto;


import Myproject.recomandplace.domain.Restaurant;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRequestDto {

    private String name;
    private String location;
    private String description;

    public Restaurant toEntity() {
        return new Restaurant(name, location, description);
    }
}
