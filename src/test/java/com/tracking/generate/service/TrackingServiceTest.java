package com.tracking.generate.service;

import com.tracking.generate.contoller.request.ParcelRequest;
import com.tracking.generate.contoller.response.TrackingResponse;
import com.tracking.generate.entity.ParcelDetails;
import com.tracking.generate.mapper.TrackingMapper;
import com.tracking.generate.repository.TrackingRepository;
import com.tracking.generate.service.impl.TrackingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class TrackingServiceTest {


    @InjectMocks
    private TrackingServiceImpl trackingService;

    @Mock
    private TrackingRepository repository;

    @Mock
    private TrackingMapper trackingMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGenerateTrackingNumber_Success() throws ExecutionException, InterruptedException {
        ParcelRequest request = new ParcelRequest();
        ParcelDetails parcelDetails = new ParcelDetails();
        String trackingNumber = "TRK12345";

        // Mock
        when(repository.save(any(ParcelDetails.class))).thenReturn(parcelDetails);
        when(trackingMapper.toTracking(request, trackingNumber)).thenReturn(parcelDetails);

        // Act
        CompletableFuture<TrackingResponse> actualResponse = trackingService.generateTrackingNumber(request);
        // Assert
        assertNotNull(actualResponse);
        assertNotNull(actualResponse.get().getTrackingNumber());
        // Verify
        verify(repository, times(1)).save(any(ParcelDetails.class));
    }

}