package Myproject.recomandplace.controller;

import Myproject.recomandplace.domain.Restaurant;
import Myproject.recomandplace.dto.CreateRequestDto;
import Myproject.recomandplace.dto.DeleteRequestDto;
import Myproject.recomandplace.dto.FindRequestDto;
import Myproject.recomandplace.dto.UpdateRequestDto;
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
    public ResponseEntity<?> create(Form form) {
        CreateRequestDto requestDto = new CreateRequestDto(form.getName(), form.getLocation(), form.getDescription());

        System.out.println("Creating restaurant " + requestDto);

        rpService.RestaurnatJoin(requestDto);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .header("Location", "/")
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

    @GetMapping(value = "/restaurant") // 단일 탐색
    public String FindOneForm() {
        return "Restaurant/restaurantFindForm";
    }

    @GetMapping(value = "/restaurantOne") // 목록
    public String printOne(Model model) {
        List<Restaurant> restaurant = rpService.findRestaurants();
        model.addAttribute("restaurants", restaurant);
        return "Restaurant/restaurantFindOne";
    }

    @PostMapping(value = "/restaurantOne")
    public ResponseEntity<?> FindOne(Form form) {
        FindRequestDto requestDto = new FindRequestDto(form.getName(), form.getLocation());

        rpService.findOneRestaurantbynameAlocation(requestDto);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .header("Location", "/restaurantOne")
                .body(requestDto);
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


    @PutMapping("/restaurants/update/location") // 위치 수정
    @ResponseBody
    public ResponseEntity<?> updatelocation(Form form) {
        UpdateRequestDto updateDto = new UpdateRequestDto(form.getName(), form.getLocation(), form.getDescription());

        rpService.RestaurantUpdatebylocation(updateDto);

        return ResponseEntity
                .status(HttpStatus.FOUND) // update완료, home으로 redirection
                .header("Location", "/")
                .body(updateDto);
    }

    @PutMapping("/restaurants/update/description") // 설명 수정
    @ResponseBody
    public ResponseEntity<?> updatedescription(Form form) {
        UpdateRequestDto updateDto = new UpdateRequestDto(form.getName(), form.getLocation(), form.getDescription());

        rpService.RestaurantUpdatebydescription(updateDto);

        return ResponseEntity
                .status(HttpStatus.FOUND) // update완료, hoome으로 redirection
                .header("Location", "/")
                .body(updateDto);
    }



    // D
    @GetMapping(value = "/restaurants/delete")
    public String deleteForm() {
        return "Restaurant/deleteRestaurant";
    }

    @DeleteMapping(value = "/restaurants/delete")
    @ResponseBody
    public ResponseEntity<?> deleteRestaurant(Form form) {
        DeleteRequestDto deleteDto = new DeleteRequestDto(form.getName(), form.getLocation());

        rpService.DeleteRestaurantbyname(deleteDto);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT) // 삭제 완료, 보낼 메세지 없음.
                .build();
    }

}
