package com.technical.interview.tunisair.domain;

import lombok.Data;

@Data
public class TunisAirRequest {

    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private int passengerCount;

}
