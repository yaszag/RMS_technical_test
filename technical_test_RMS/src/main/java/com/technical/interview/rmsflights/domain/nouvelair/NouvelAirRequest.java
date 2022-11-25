package com.technical.interview.rmsflights.domain.nouvelair;

import org.springframework.web.util.UriComponentsBuilder;

public class NouvelAirRequest {

    private String from;
    private String to;
    private String outboundDate;
    private String inboundDate;
    private int numberOfAdults;

    public String getFrom() {
        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public String getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(final String outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(final String inboundDate) {
        this.inboundDate = inboundDate;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(final int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public UriComponentsBuilder buildQueryParams(UriComponentsBuilder uriComponentsBuilder){
        return uriComponentsBuilder.queryParam("from", getFrom())
                .queryParam("to",getTo())
                .queryParam("outboundDate",getOutboundDate())
                .queryParam("inboundDate",getInboundDate())
                .queryParam("numberOfAdults", getNumberOfAdults());
    }
}
