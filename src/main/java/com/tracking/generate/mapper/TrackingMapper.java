package com.tracking.generate.mapper;

import com.tracking.generate.contoller.request.ParcelRequest;
import com.tracking.generate.contoller.response.TrackingResponse;
import com.tracking.generate.entity.ParcelDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class TrackingMapper {

    public static final TrackingMapper INSTANCE = Mappers.getMapper(TrackingMapper.class);
    public abstract ParcelDetails toTracking(ParcelRequest request, String trackingNumber);
    @Mapping(target = "createdAt", source = "parcelDetails.createdAt")
    @Mapping(target = "trackingNumber", source = "trackingNumber")
    public abstract TrackingResponse toTrackingResponse(ParcelDetails parcelDetails, String trackingNumber);

    @Mapping(target = "createdAt", source = "createdAt")
    public abstract ParcelRequest toCreateParcelRequest(String originCountryId, String destinationCountryId, Double weight, String createdAt, String customerId, String customerName, String customerSlug);
}
