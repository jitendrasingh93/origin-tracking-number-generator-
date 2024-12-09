package com.tracking.generate.service;

import com.tracking.generate.contoller.request.ParcelRequest;
import com.tracking.generate.contoller.response.TrackingResponse;

import java.util.concurrent.CompletableFuture;

public interface TrackingService {
    CompletableFuture<TrackingResponse> generateTrackingNumber(ParcelRequest request);

}
