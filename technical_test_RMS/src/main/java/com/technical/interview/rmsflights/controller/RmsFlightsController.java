package com.technical.interview.rmsflights.controller;


import com.technical.interview.rmsflights.domain.rmsflights.RmsFlightsRequest;
import com.technical.interview.rmsflights.domain.rmsflights.RmsFlightsResponse;
import com.technical.interview.rmsflights.service.RmsFlightsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class RmsFlightsController {

    private final RmsFlightsService rmsFlightsService;

    public RmsFlightsController(RmsFlightsService rmsFlightsService) {
        this.rmsFlightsService = rmsFlightsService;
    }

    @GetMapping()
    public List<RmsFlightsResponse> searchFlights(@Valid RmsFlightsRequest rmsFlightsRequest){
        return rmsFlightsService.searchFlights(rmsFlightsRequest);
    }
}
