package com.example.code.api;

import com.example.code.model.dto.RequestHotelDTO;
import com.example.code.model.dto.ResponseHotelDTO;
import com.example.code.services.HotelService.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // server/hotels
    @GetMapping
    public ResponseEntity<List<ResponseHotelDTO>> getHotels(@RequestBody RequestHotelDTO requestHotelDTO) {
        return ResponseEntity.ok().body(hotelService.getHotels(requestHotelDTO));
    }
}
