package Myproject.recomandplace.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteDto {

    @Column(nullable = false)
    private Long id;

}
