package Myproject.recomandplace.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;


@Entity
@Getter
@Table(name = "Restaurant")
public class Restaurant {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    @Column(nullable = false)
    private String name; // 상호명

    @Column(nullable = false)
    private String location; // 위치

    @Column(length = 1000)
    private String description; // 설명

    @Builder
    public Restaurant(String name, String location, String description) {
        this.name = name;
        this.location =  location;
        this.description = description;
    }

    public void updateLocation(String location){
        this.location = location;
    }

    public void updateDescription(String description){
        this.description = description;
    }
}