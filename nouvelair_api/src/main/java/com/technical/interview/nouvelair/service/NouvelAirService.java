package com.technical.interview.nouvelair.service;

import com.technical.interview.nouvelair.domain.NouvelAirRequest;
import com.technical.interview.nouvelair.domain.NouvelAirResponse;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NouvelAirService {

    private List<NouvelAirResponse> nouvelAirRespons = new ArrayList<>();

    @PostConstruct
    private void intFlightsList() {
        nouvelAirRespons.add(new NouvelAirResponse("nouvelair", 200.21,100.32, 20.0, "TUN", "FRA", "2022-07-08T09:28:27.141", "2022-07-09T09:28:27.141"));
        nouvelAirRespons.add(new NouvelAirResponse("nouvelair", 250.21,110.32, 15.0, "TUN", "FRA", "2022-07-08T09:28:27.141", "2022-07-09T09:28:27.141"));
    }

    public List<NouvelAirResponse> findFlights(NouvelAirRequest nouvelAirRequest) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return nouvelAirRespons.stream()
                .filter(response -> {
                            try {
                                return nouvelAirRequest.getFrom().equals(response.getDepartureAirportName())
                                         && nouvelAirRequest.getTo().equals(response.getArrivalAirportName())
                                         && sdf.parse(nouvelAirRequest.getInboundDate()).equals(sdf.parse(response.getInboundDateTime()))
                                         && sdf.parse(nouvelAirRequest.getOutboundDate()).equals(sdf.parse(response.getOutboundDateTime()));


                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            return false;
                        }
                )
                .collect(Collectors.toList());
    }
}

