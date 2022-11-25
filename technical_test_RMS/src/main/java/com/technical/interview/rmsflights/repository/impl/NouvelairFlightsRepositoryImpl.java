package com.technical.interview.rmsflights.repository.impl;

import com.technical.interview.rmsflights.domain.mapper.DomainMapper;
import com.technical.interview.rmsflights.domain.nouvelair.NouvelAirRequest;
import com.technical.interview.rmsflights.domain.nouvelair.NouvelAirResponse;
import com.technical.interview.rmsflights.domain.rmsflights.RmsFlightsRequest;
import com.technical.interview.rmsflights.domain.rmsflights.RmsFlightsResponse;
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
public class NouvelairFlightsRepositoryImpl implements FlightsProviderRepository {

    @Value("${repositories.nouvelair.flights.api.url}")
    String nouvelairFlightUrl;


    private final RestTemplate restTemplate;

    public NouvelairFlightsRepositoryImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<RmsFlightsResponse> searchFlights(RmsFlightsRequest rmsFlightsRequest) {


        NouvelAirRequest request = DomainMapper.mapToNouvelair(rmsFlightsRequest);
        UriComponents urlBuilder = request.buildQueryParams(UriComponentsBuilder.fromHttpUrl(nouvelairFlightUrl))
               .build();

        return restTemplate.exchange(urlBuilder.toUriString(), HttpMethod.GET, null,
                new ParameterizedTypeReference<List<NouvelAirResponse>>() {}).getBody().stream().map(DomainMapper::map).collect(Collectors.toList());
    }
}
