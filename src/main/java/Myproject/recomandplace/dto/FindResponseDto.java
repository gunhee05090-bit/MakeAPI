package Myproject.recomandplace.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FindResponseDto {

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    public FindResponseDto(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return "FindResponseDto{" + "name=" + name + ", location=" + location + '}';
    }
}
