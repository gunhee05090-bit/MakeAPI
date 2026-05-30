package Myproject.recomandplace.service;

import Myproject.recomandplace.domain.Restaurant;
import Myproject.recomandplace.dto.CreateRequestDto;
import Myproject.recomandplace.dto.RestaurantResponseDto;
import Myproject.recomandplace.dto.UpdateDto;
import Myproject.recomandplace.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RPService {

    private final PlaceRepository placeRepository;

    @Autowired
    public RPService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }


    // 중복 처리
    private void NotDoubleJoinRestaurant(Restaurant restaurant){
        placeRepository.findByName(restaurant.getName())
                .ifPresent(rp1 -> {
                    throw new IllegalStateException("이미 추천된 장소입니다.");
                });
        placeRepository.findByLocation(restaurant.getLocation())
                .ifPresent(rp2 -> {
                    throw new IllegalStateException("이미 추천된 위치 입니다.");
                });
    }


    // 가게 등록
    public String RestaurnatJoin(CreateRequestDto requestDto){
        Restaurant restaurant = requestDto.toEntity();
        NotDoubleJoinRestaurant(restaurant);
        return placeRepository.save(requestDto.toEntity()).getName();
    }


    // 전체 호출
    public List<Restaurant> findRestaurants(){
        return placeRepository.findAll();
    }


    // 부분 호출 장소 이름
    public String findOneRestaurantbyname(String name){
        Restaurant restaurant = placeRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException(name + "은 추천 되지 않은 장소입니다."));
        return new RestaurantResponseDto(restaurant).toString();
    }

    // 부분 호출 장소 위치
    public String findOneRestaurantbylocation(String location){
        Restaurant restaurant = placeRepository.findByName(location)
                .orElseThrow(() -> new IllegalArgumentException(location + "추천된 장소가 없는 위치입니다."));
        return new RestaurantResponseDto(restaurant).toString();
    }

    // 삭제
    public void DeleteRestaurantbyname(Long id){
        Restaurant restaurant = placeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id + "을 찾을 수 없습니다."));
    }


    // 장소 위치 수정
    public String RestaurantUpdatebylocation(UpdateDto updateDto){
        Restaurant restaurant = placeRepository.findByName(updateDto.getName())
                .orElseThrow(() -> new IllegalArgumentException(updateDto.getName() + "은 추천되지 않은 장소 입니다."));

        restaurant.updateLocation(updateDto.getLocation());

        return updateDto.getName();
    }

    // 장소 설명 수정
    public String RestaurantUpdatebydescription(UpdateDto updateDto){
        Restaurant restaurant = placeRepository.findByName(updateDto.getName())
                .orElseThrow(() -> new IllegalArgumentException(updateDto.getName() + "은 추천되지 않은 장소 입니다."));

        restaurant.updateDescription(updateDto.getDescription());

        return updateDto.getName();
    }


}
