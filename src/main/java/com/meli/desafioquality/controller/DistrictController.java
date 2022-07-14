package com.meli.desafioquality.controller;

import com.meli.desafioquality.model.District;
import com.meli.desafioquality.service.ICalculateProperty;
import com.meli.desafioquality.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    IDistrictService districtService;

    @GetMapping()
    public ResponseEntity<List<District>> getAllDistricts() {
        return ResponseEntity.ok(districtService.getAllDistricts());
    }

    @PostMapping("/registerDistrict")
    public ResponseEntity<District> registerDistrict(@RequestBody @Valid District district){

        return ResponseEntity.status(HttpStatus.CREATED).body(districtService.createDistrict(district));
    }
}
