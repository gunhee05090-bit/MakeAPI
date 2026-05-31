package Myproject.recomandplace.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Table(name = "Restaurant")
@NoArgsConstructor
public class Restaurant {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    @Setter
    @Column(nullable = false)
    private String name; // 상호명

    @Setter
    @Column(nullable = false)
    private String location; // 위치

    @Setter
    @Column(length = 1000)
    private String description; // 설명

    @Builder
    public Restaurant(String name, String location, String description) {
        this.name = name;
        this.location =  location;
        this.description = description;
    }
}