package com.technical.interview.rmsflights.service;


import com.technical.interview.rmsflights.domain.rmsflights.RmsFlightsRequest;
import com.technical.interview.rmsflights.domain.rmsflights.RmsFlightsResponse;

import java.util.List;

public interface RmsFlightsService {
    List<RmsFlightsResponse> searchFlights(RmsFlightsRequest rmsFlightsRequest);
}
