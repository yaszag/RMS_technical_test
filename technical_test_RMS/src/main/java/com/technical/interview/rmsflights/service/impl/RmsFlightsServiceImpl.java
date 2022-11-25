package com.technical.interview.rmsflights.service.impl;

import com.technical.interview.rmsflights.domain.rmsflights.RmsFlightsRequest;
import com.technical.interview.rmsflights.domain.rmsflights.RmsFlightsResponse;
import com.technical.interview.rmsflights.repository.FlightsProviderRepository;
import com.technical.interview.rmsflights.service.RmsFlightsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class RmsFlightsServiceImpl implements RmsFlightsService {


    private final FlightsProviderRepository tunisairFlightsRepository;
    private final FlightsProviderRepository nouvelAirFlightsRepository;

    public RmsFlightsServiceImpl(@Qualifier("tunisairFlightsRepositoryImpl") FlightsProviderRepository tunisairFlightsRepository, @Qualifier("nouvelairFlightsRepositoryImpl") FlightsProviderRepository nouvelAirFlightsRepository) {
        this.tunisairFlightsRepository = tunisairFlightsRepository;
        this.nouvelAirFlightsRepository = nouvelAirFlightsRepository;
    }

    @Override
    public List<RmsFlightsResponse> searchFlights(RmsFlightsRequest rmsFlightsRequest) {
       
        CompletableFuture<List<RmsFlightsResponse>> tunisairFlights = CompletableFuture.completedFuture(tunisairFlightsRepository.searchFlights(rmsFlightsRequest));
        CompletableFuture<List<RmsFlightsResponse>> nouvelairFlights = CompletableFuture.completedFuture(nouvelAirFlightsRepository.searchFlights(rmsFlightsRequest));
        return mergeFlights(tunisairFlights,nouvelairFlights);
    }

    List<RmsFlightsResponse> mergeFlights(CompletableFuture<List<RmsFlightsResponse>> ...flights){
     return Stream.of(flights)
                .map(CompletableFuture::join)
             .flatMap(List::stream).sorted(Comparator.comparingDouble(RmsFlightsResponse::getFare))
                .collect(Collectors.toList());

    }


}
