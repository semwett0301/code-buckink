package com.example.code.api;

import com.example.code.model.dto.ResponseCityDTO;
import com.example.code.services.CityService.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cities")
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    // server/cities/top?amount=8
    @GetMapping("/top")
    public ResponseEntity<List<ResponseCityDTO>> getTopCities(@RequestParam int amount) {
        return ResponseEntity.ok().body(cityService.getTopCities(amount));
    }

    // server/cities/part?part="abc"
    @GetMapping("/part")
    public ResponseEntity<List<ResponseCityDTO>> getCitiesByPartOfName(@RequestParam String part) {
        return ResponseEntity.ok().body(cityService.getCitiesByPartOfName(part));
    }

}
