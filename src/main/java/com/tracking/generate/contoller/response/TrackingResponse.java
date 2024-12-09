package com.tracking.generate.contoller.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class TrackingResponse {

    private String trackingNumber;
    private String createdAt;

}
