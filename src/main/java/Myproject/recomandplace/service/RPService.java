package Myproject.recomandplace.service;

import Myproject.recomandplace.domain.Restaurant;
import Myproject.recomandplace.dto.*;
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

    // 미등록 확인 (이름)
    private void PresentQueryName(Restaurant restaurant){
        placeRepository.findByName(restaurant.getName())
                .orElseThrow(() -> new IllegalArgumentException(restaurant.getName() + "은 추천 되지 않은 장소입니다."));
    }

    // 미등록 확인 (위치)
    private void PresentQueryLocation(Restaurant restaurant){
        placeRepository.findByName(restaurant.getLocation())
                .orElseThrow(() -> new IllegalArgumentException(restaurant.getName() + "은 추천 되지 않은 위치입니다."));
    }


    // 가게 등록
    public String RestaurnatJoin(CreateRequestDto requestDto){
        Restaurant restaurant = requestDto.toEntity();
        NotDoubleJoinRestaurant(restaurant);
        placeRepository.save(restaurant);
        return "redirect:/";
    }


    // 전체 호출
    public List<Restaurant> findRestaurants(){
        return placeRepository.findAll();
    }


    // 부분 호출
    public String findOneRestaurantbynameAlocation(FindRequestDto requestDto){
        Restaurant restaurant = requestDto.toEntity();
        PresentQueryName(restaurant);
        PresentQueryLocation(restaurant);
        FindResponseDto findResponseDto = new FindResponseDto(restaurant.getName(), restaurant.getLocation());
        return findResponseDto.toString();
    }

    // 삭제
    public void DeleteRestaurantbyname(Long id){
        Restaurant restaurant = placeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(id + "을 찾을 수 없습니다."));
    }


    // 장소 위치 수정
    public String RestaurantUpdatebylocation(UpdateRequestDto updateDto){
        Restaurant restaurant = updateDto.toEntity();
        PresentQueryName(restaurant);
        restaurant.updateLocation(updateDto.getLocation());

        return updateDto.getName();
    }

    // 장소 설명 수정
    public String RestaurantUpdatebydescription(UpdateRequestDto updateDto){
        Restaurant restaurant = updateDto.toEntity();
        PresentQueryName(restaurant);
        restaurant.updateDescription(updateDto.getDescription());

        return updateDto.getName();
    }


}
