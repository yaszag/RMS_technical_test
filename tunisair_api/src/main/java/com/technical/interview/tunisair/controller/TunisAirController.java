package com.technical.interview.tunisair.controller;

import com.technical.interview.tunisair.domain.TunisAirRequest;
import com.technical.interview.tunisair.service.TunisAirService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "TunisAir Management System")
@RestController
@RequestMapping("/tunisair")
public class TunisAirController {

    private final TunisAirService tunisAirService;

    @Autowired
    public TunisAirController(TunisAirService tunisAirService) {
        this.tunisAirService = tunisAirService;
    }

    @ApiOperation(value = "Get All Flights")
    @GetMapping("/flights")
    public ResponseEntity<?> findAll(@RequestParam("origin") String origin,
                                     @RequestParam("destination") String destination,
                                     @RequestParam("departureDate") String departureDate,
                                     @RequestParam("returnDate") String returnDate) {
        TunisAirRequest tunisAirRequest = new TunisAirRequest();
        tunisAirRequest.setOrigin(origin);
        tunisAirRequest.setDestination(destination);
        tunisAirRequest.setDepartureDate(departureDate);
        tunisAirRequest.setReturnDate(returnDate);
        return new ResponseEntity<>(tunisAirService.findFlights(tunisAirRequest), HttpStatus.OK);
    }
}
