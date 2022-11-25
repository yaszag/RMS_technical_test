package com.technical.interview.rmsflights.repository.impl;

import com.technical.interview.rmsflights.domain.mapper.DomainMapper;
import com.technical.interview.rmsflights.domain.rmsflights.RmsFlightsRequest;
import com.technical.interview.rmsflights.domain.rmsflights.RmsFlightsResponse;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirRequest;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirResponse;
import com.technical.interview.rmsflights.repository.FlightsProviderRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TunisairFlightsRepositoryImpl implements FlightsProviderRepository {

    @Value("${repositories.tunisair.flights.api.url}")
    String tunisairFlightUrl;

    private final RestTemplate restTemplate;

    public TunisairFlightsRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<RmsFlightsResponse> searchFlights(RmsFlightsRequest rmsFlightsRequest) {
        TunisAirRequest request = DomainMapper.mapToTunisair(rmsFlightsRequest);
        UriComponents urlBuilder = request.buildQueryParams(UriComponentsBuilder.fromHttpUrl(tunisairFlightUrl))
                .build();

        return restTemplate.exchange(urlBuilder.toUriString(), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<TunisAirResponse>>() {}).getBody().stream().map(DomainMapper::map).collect(Collectors.toList());
    }
}
