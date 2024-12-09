package com.tracking.generate.mapper;

import com.tracking.generate.utility.Utility;
import com.tracking.generate.contoller.request.ParcelRequest;
import com.tracking.generate.contoller.response.TrackingResponse;
import com.tracking.generate.entity.ParcelDetails;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

class ParcelDetailsMapperTest {

    @Test
    public void toConvertIntoParcelEntity() {
        ParcelRequest request = new ParcelRequest();
        String id = UUID.randomUUID().toString();
        request.setCustomerId(id);
        request.setCustomerName("Max");
        ParcelDetails parcelDetails = TrackingMapper.INSTANCE.toTracking(request, Utility.generateTrackingNumber());
        Assertions.assertThat(parcelDetails).isNotNull();
        Assertions.assertThat(parcelDetails.getCustomerId()).isEqualTo(id);
        Assertions.assertThat(parcelDetails.getCustomerName()).isEqualTo("Max");

    }

    @Test
    public void toGenerateTrackingResponse() {
        ParcelDetails details = new ParcelDetails();
        details.setCustomerId(UUID.randomUUID().toString());
        details.setCustomerName("Max");
        details.setCreatedAt(createdRFC3339FormatDate());
        String trackingNum = UUID.randomUUID().toString();
        TrackingResponse trackingResponse = TrackingMapper.INSTANCE.toTrackingResponse(details, trackingNum);
        Assertions.assertThat(trackingResponse).isNotNull();
        Assertions.assertThat(trackingResponse.getTrackingNumber()).isEqualTo(trackingNum);

    }

    public static String createdRFC3339FormatDate() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(new Date());
    }
}