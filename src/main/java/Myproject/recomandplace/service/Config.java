package Myproject.recomandplace.service;

import Myproject.recomandplace.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private final PlaceRepository placeRepository;

    @Autowired
    public Config(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Bean
    public RPService RPService() {
        return new RPService(placeRepository);
    }

}
