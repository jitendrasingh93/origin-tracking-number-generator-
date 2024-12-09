package com.tracking.generate.service.impl;

import com.tracking.generate.Utility;
import com.tracking.generate.contoller.request.ParcelRequest;
import com.tracking.generate.contoller.response.TrackingResponse;
import com.tracking.generate.entity.ParcelDetails;
import com.tracking.generate.mapper.TrackingMapper;
import com.tracking.generate.repository.TrackingRepository;
import com.tracking.generate.service.TrackingService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class TrackingServiceImpl implements TrackingService {

    @Autowired
    private TrackingRepository repository;

    @Transactional
    @Override
    @Async
    public CompletableFuture<TrackingResponse> generateTrackingNumber(ParcelRequest request) {
        log.info("Request received={}", request);
        String trackingNumber = Utility.generateTrackingNumber();
        Utility.createdRFC3339FormatDate();
        ParcelDetails parcelDetails = repository.save(TrackingMapper.INSTANCE.toTracking(request, trackingNumber));
        TrackingResponse tackingResponse = TrackingMapper.INSTANCE.toTrackingResponse(parcelDetails, trackingNumber);
        log.info("Tracking Response={}", tackingResponse);
        return CompletableFuture.completedFuture(tackingResponse);
    }

}
