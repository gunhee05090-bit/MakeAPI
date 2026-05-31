package Myproject.recomandplace.dto;

import Myproject.recomandplace.domain.Restaurant;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteRequestDto {

    @Column(nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    public DeleteRequestDto(String name, String location) {}

    public Restaurant toEntity(){
        return new Restaurant(this.name, this.location, this.description);
    }

}
