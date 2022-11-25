package com.technical.interview.rmsflights.repository;

import com.technical.interview.rmsflights.domain.rmsflights.RmsFlightsRequest;
import com.technical.interview.rmsflights.domain.rmsflights.RmsFlightsResponse;

import java.util.List;

public interface FlightsProviderRepository {

    List<RmsFlightsResponse> searchFlights(RmsFlightsRequest rmsFlightsRequest);
}
