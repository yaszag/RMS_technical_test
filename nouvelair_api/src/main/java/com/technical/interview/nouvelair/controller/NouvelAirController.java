package com.technical.interview.nouvelair.controller;

import com.technical.interview.nouvelair.domain.NouvelAirRequest;
import com.technical.interview.nouvelair.service.NouvelAirService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "Nouvelair Management System")
@RestController
@RequestMapping("/nouvelair")
public class NouvelAirController {

    private final NouvelAirService nouvelAirService;

    @Autowired
    public NouvelAirController(NouvelAirService nouvelAirService) {
        this.nouvelAirService = nouvelAirService;
    }

    @ApiOperation(value = "Get All Flights")
    @GetMapping("/flights")
    public ResponseEntity<?> findAll(@RequestParam("from") String from,
                                     @RequestParam("to") String to,
                                     @RequestParam("outboundDate") String outboundDate,
                                     @RequestParam("inboundDate") String inboundDate) {
        NouvelAirRequest nouvelAirRequest = new NouvelAirRequest();
        nouvelAirRequest.setFrom(from);
        nouvelAirRequest.setTo(to);
        nouvelAirRequest.setOutboundDate(outboundDate);
        nouvelAirRequest.setInboundDate(inboundDate);
        return new ResponseEntity<>(nouvelAirService.findFlights(nouvelAirRequest), HttpStatus.OK);
    }
}
