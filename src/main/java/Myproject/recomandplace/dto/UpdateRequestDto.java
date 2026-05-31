package Myproject.recomandplace.dto;

import Myproject.recomandplace.domain.Restaurant;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRequestDto {

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;


    public Restaurant toEntity() {
        return new Restaurant(this.name, this.location, this.description);
    }

}
