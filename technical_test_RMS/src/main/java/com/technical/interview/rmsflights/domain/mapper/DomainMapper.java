package com.technical.interview.rmsflights.domain.mapper;

import com.technical.interview.rmsflights.domain.nouvelair.NouvelAirRequest;
import com.technical.interview.rmsflights.domain.nouvelair.NouvelAirResponse;
import com.technical.interview.rmsflights.domain.rmsflights.RmsFlightsRequest;
import com.technical.interview.rmsflights.domain.rmsflights.RmsFlightsResponse;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirRequest;
import com.technical.interview.rmsflights.domain.tunisair.TunisAirResponse;

public class DomainMapper {


    public static RmsFlightsResponse map(TunisAirResponse tunisAirResponse){
        RmsFlightsResponse rmsFlightsResponse = new RmsFlightsResponse();
        rmsFlightsResponse.setAirline(tunisAirResponse.getAirline());
        rmsFlightsResponse.setArrivalDate(tunisAirResponse.getArrivalDate());
        rmsFlightsResponse.setDepartureDate(tunisAirResponse.getDepartureDate());
        rmsFlightsResponse.setDepartureAirportCode(tunisAirResponse.getDepartureAirportCode());
        rmsFlightsResponse.setDestinationAirportCode(tunisAirResponse.getDestinationAirportCode());
        rmsFlightsResponse.setFare(tunisAirResponse.getPrice());
        return rmsFlightsResponse;
    }

    public static RmsFlightsResponse map(NouvelAirResponse nouvelAirResponse){
        RmsFlightsResponse rmsFlightsResponse = new RmsFlightsResponse();
        rmsFlightsResponse.setAirline(nouvelAirResponse.getCarrier());
        rmsFlightsResponse.setArrivalDate(nouvelAirResponse.getInboundDateTime());
        rmsFlightsResponse.setDepartureDate(nouvelAirResponse.getOutboundDateTime());
        rmsFlightsResponse.setDepartureAirportCode(nouvelAirResponse.getDepartureAirportName());
        rmsFlightsResponse.setDestinationAirportCode(nouvelAirResponse.getArrivalAirportName());

        rmsFlightsResponse.setFare(nouvelAirResponse.getFare());
        return rmsFlightsResponse;
    }

    public static TunisAirRequest mapToTunisair(RmsFlightsRequest rmsFlightsRequest){
        TunisAirRequest tunisAirRequest = new TunisAirRequest();
        tunisAirRequest.setDepartureDate(rmsFlightsRequest.getDepartureDate());
        tunisAirRequest.setReturnDate(rmsFlightsRequest.getReturnDate());
        tunisAirRequest.setOrigin(rmsFlightsRequest.getOrigin());
        tunisAirRequest.setDestination(rmsFlightsRequest.getDestination());
        tunisAirRequest.setPassengerCount(rmsFlightsRequest.getNumberOfPassengers());
        return tunisAirRequest;

    }

    public static NouvelAirRequest mapToNouvelair(RmsFlightsRequest rmsFlightsRequest){
        NouvelAirRequest nouvelAirRequest = new NouvelAirRequest();
        nouvelAirRequest.setOutboundDate(rmsFlightsRequest.getDepartureDate());
        nouvelAirRequest.setInboundDate(rmsFlightsRequest.getReturnDate());
        nouvelAirRequest.setTo(rmsFlightsRequest.getDestination());
        nouvelAirRequest.setFrom(rmsFlightsRequest.getOrigin());
        nouvelAirRequest.setNumberOfAdults(rmsFlightsRequest.getNumberOfPassengers());
        return nouvelAirRequest;

    }
}
