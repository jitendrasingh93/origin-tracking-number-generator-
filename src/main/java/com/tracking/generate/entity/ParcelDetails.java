package com.tracking.generate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "parcel_details")
@Getter
@Setter
public class ParcelDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "origin_country_id")
    private String originCountryId;

    @Column(name = "destination_country_id")
    private String destinationCountryId;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_slug")
    private String customerSlug;

    @Column(name = "tracking_number")
    private String trackingNumber;

}
