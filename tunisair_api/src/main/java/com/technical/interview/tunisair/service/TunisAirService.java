package com.technical.interview.tunisair.service;

import com.technical.interview.tunisair.domain.TunisAirRequest;
import com.technical.interview.tunisair.domain.TunisAirResponse;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TunisAirService {

    private List<TunisAirResponse> tunisAirResponses = new ArrayList<>();

    @PostConstruct
    private void intFlightsList() {
        tunisAirResponses.add(new TunisAirResponse("tunisiar", 100.21, "E", "FRA", "TUN", "2022-07-08T11:44:44.797", "2022-07-09T11:44:44.797"));
        tunisAirResponses.add(new TunisAirResponse("tunisiar", 90.21, "B", "FRA", "TUN", "2022-07-08T11:44:44.797", "2022-07-09T11:44:44.797"));
        tunisAirResponses.add(new TunisAirResponse("tunisiar", 10.21, "A", "TUN", "FRA", "2022-07-08T11:44:44.797", "2022-07-09T11:44:44.797"));
    }

    public List<TunisAirResponse> findFlights(TunisAirRequest tunisAirRequest) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return tunisAirResponses.stream()
                .filter(response -> {
                            try {
                                return tunisAirRequest.getOrigin().equals(response.getDepartureAirportCode())
                                        && tunisAirRequest.getDestination().equals(response.getDestinationAirportCode())
                                        && sdf.parse(tunisAirRequest.getDepartureDate()).equals(sdf.parse(response.getDepartureDate()))
                                        && sdf.parse(tunisAirRequest.getReturnDate()).equals(sdf.parse(response.getArrivalDate()));

                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            return false;
                        }
                )
                .collect(Collectors.toList());
    }
}

