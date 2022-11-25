package com.technical.interview.nouvelair.domain;

import lombok.Data;

@Data
public class NouvelAirRequest {

    private String from;
    private String to;
    private String outboundDate;
    private String inboundDate;
    private int numberOfAdults;

}
