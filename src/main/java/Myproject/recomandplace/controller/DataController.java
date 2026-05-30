package Myproject.recomandplace.controller;

import Myproject.recomandplace.domain.Restaurant;
import Myproject.recomandplace.dto.CreateRequestDto;
import Myproject.recomandplace.dto.DeleteDto;
import Myproject.recomandplace.dto.UpdateDto;
import Myproject.recomandplace.service.RPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DataController {

    private final RPService rpService;

    @Autowired
    public DataController(RPService rpService) {
        this.rpService = rpService;
    }


    // C
    @GetMapping(value = "/restaurants/new")
    public String createForm() {
        return "Restaurant/joinRestaurant";
    }

    @PostMapping("/restaurants/new")
    @ResponseBody
    public ResponseEntity<?> create(CreateRequestDto requestDto) {
        rpService.RestaurnatJoin(requestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "/" + requestDto)
                .body(requestDto);
    }


    // R
    @GetMapping(value = "/restaurantf")
    public String FindForm() {
        return "Restaurant/restaurantFind";
    }

    @GetMapping(value = "/restaurants") // 목록
    public String list(Model model) {
        List<Restaurant> restaurant = rpService.findRestaurants();
        model.addAttribute("restaurants", restaurant);
        return "Restaurant/restaurantList";
    }

    @GetMapping(value = "/restaurantName") // 단일 이름
    public String FindOnebyName(Model model) {
        String restaurant = rpService.findOneRestaurantbyname(model.toString());
        model.addAttribute("restaurants", restaurant);
        return "Restaurant/restaurantFindOne";
    }

    @GetMapping(value = "/restaurantName") // 단일 이름
    public String FindOnebyLocation(Model model) {
        String restaurant = rpService.findOneRestaurantbylocation(model.toString());
        model.addAttribute("restaurants", restaurant);
        return "Restaurant/restaurantFindOne";
    }


    // U
    @GetMapping(value = "/restaurants/update") // 수정 대상 선택
    public String updateForm() {
        return "Restaurant/updateRestaurant";
    }

    @GetMapping(value = "/restaurants/update/location") // 위치 수정
    public String updateFormLocation() {
        return "Restaurant/updateRestaurantLocation";
    }

    @GetMapping(value = "/restaurants/update/description") // 설명 수정
    public String updateFormDescription() {
        return "Restaurant/updateRestaurantDescription";
    }


    @PostMapping("/restaurants/update/location") // 위치 수정
    @ResponseBody
    public ResponseEntity<?> updatelocation(UpdateDto requestDto) {
        rpService.RestaurantUpdatebylocation(requestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Location", "/" + requestDto)
                .body(requestDto);
    }

    @PostMapping("/restaurants/update/description") // 설명 수정
    @ResponseBody
    public ResponseEntity<?> updatedescription(UpdateDto requestDto) {
        rpService.RestaurantUpdatebydescription(requestDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Location", "/" + requestDto)
                .body(requestDto);
    }



    // D
    @GetMapping(value = "/restaurants/delete")
    public String deleteForm() {
        return "Restaurant/deleteRestaurant";
    }

    @DeleteMapping(value = "/restaurants/delete")
    @ResponseBody
    public ResponseEntity<?> deleteRestaurant(DeleteDto requestDto) {
        rpService.DeleteRestaurantbyname(requestDto.getId());

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT) // 삭제 완료, 보낼 메세지 없음
                .header("Location", "/" + requestDto)
                .body(requestDto);
    }

}
