package Myproject.recomandplace.dto;


import Myproject.recomandplace.domain.Restaurant;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FindRequestDto {

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    public FindRequestDto(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Autowired
    public Restaurant toEntity() {
        return new Restaurant(name, location, description);
    }


}
