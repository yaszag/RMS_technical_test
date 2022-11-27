# RMS_technical_test

    This solution contains three different applications, two external applications contains the Tunisair_api and nouvelair_api.  
    the third one contains our api Rms_api

# Swagger

    -nouvelair_api: http://localhost:9090/swagger-ui.html
    -tunisair_api: http://localhost:9080/swagger-ui.html
    -rms_api: http://localhost:8081/swagger-ui.html

# API testing

    please use the following parameters to get data in the response.

    nouvelair_api: http://localhost:9090/nouvelair/flights?from=FRA&inboundDate=2022-07-09&outboundDate=2022-07-08&to=TUN
    tunisair_api: http://localhost:9080/tunisair/flights?departureDate=2022-07-08&destination=TUN&origin=FRA&returnDate=2022-07-09
    rms_api: http://localhost:8081/rmsflight/flights?departureDate=2022-07-08&destination=TUN&origin=FRA&returnDate=2022-07-09
