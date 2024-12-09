package com.tracking.generate.contoller;

import com.tracking.generate.contoller.request.ParcelRequest;
import com.tracking.generate.contoller.response.TrackingResponse;
import com.tracking.generate.service.impl.TrackingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(TrackingController.class)
class TrackingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TrackingServiceImpl service;

    @InjectMocks
    private TrackingController controller;

    @BeforeEach
    public void setUp() {
        controller = new TrackingController();
    }

    @Test
    public void testGenerateTrackingNumber_ValidInput() throws Exception {
        String originCountryId = "US";
        String destinationCountryId = "CA";
        String weight = "2.5";
        String createdAt = "2024-12-08T12:00:00Z";
        String customerId = "12345";
        String customerName = "John Doe";
        String customerSlug = "john-doe";

        TrackingResponse mockResponse = new TrackingResponse(); // Use an appropriate response class

        // Mock the service call
        when(service.generateTrackingNumber(any(ParcelRequest.class)))
                .thenReturn(CompletableFuture.completedFuture(mockResponse));

        mockMvc.perform(MockMvcRequestBuilders.get("/next-tracking-number")
                        .param("origin_country_id", originCountryId)
                        .param("destination_country_id", destinationCountryId)
                        .param("weight", weight)
                        .param("created_at", createdAt)
                        .param("customer_id", customerId)
                        .param("customer_name", customerName)
                        .param("customer_slug", customerSlug)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGenerateTrackingNumber_InvalidOriginCountryId() throws Exception {
        String originCountryId = "Us"; // Invalid: not uppercase
        String destinationCountryId = "CA";
        String weight = "2.55";
        String createdAt = "2024-12-08T12:00:00Z";
        String customerId = "12345";
        String customerName = "John Doe";
        String customerSlug = "john-doe";

        mockMvc.perform(MockMvcRequestBuilders.get("/next-tracking-number")
                        .param("origin_country_id", originCountryId)
                        .param("destination_country_id", destinationCountryId)
                        .param("weight", weight)
                        .param("created_at", createdAt)
                        .param("customer_id", customerId)
                        .param("customer_name", customerName)
                        .param("customer_slug", customerSlug)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testGenerateTrackingNumber_EmptyWeight() throws Exception {
        String originCountryId = "US";
        String destinationCountryId = "CA";
        String weight = ""; // Invalid: empty weight
        String createdAt = "2024-12-08T12:00:00Z";
        String customerId = "12345";
        String customerName = "John Doe";
        String customerSlug = "john-doe";

        mockMvc.perform(MockMvcRequestBuilders.get("/next-tracking-number")
                        .param("origin_country_id", originCountryId)
                        .param("destination_country_id", destinationCountryId)
                        .param("weight", weight)
                        .param("created_at", createdAt)
                        .param("customer_id", customerId)
                        .param("customer_name", customerName)
                        .param("customer_slug", customerSlug)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testGenerateTrackingNumber_MissingCustomerId() throws Exception {
        String originCountryId = "US";
        String destinationCountryId = "CA";
        String weight = "2.5";
        String createdAt = "2024-12-08T12:00:00Z";
        String customerId = ""; // Invalid: empty customerId
        String customerName = "John Doe";
        String customerSlug = "john-doe";

        mockMvc.perform(MockMvcRequestBuilders.get("/next-tracking-number")
                        .param("origin_country_id", originCountryId)
                        .param("destination_country_id", destinationCountryId)
                        .param("weight", weight)
                        .param("created_at", createdAt)
                        .param("customer_id", customerId)
                        .param("customer_name", customerName)
                        .param("customer_slug", customerSlug)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testGenerateTrackingNumber_InvalidCreatedAt() throws Exception {
        String originCountryId = "US";
        String destinationCountryId = "CA";
        String weight = "2.5";
        String createdAt = ""; // Invalid: empty createdAt
        String customerId = "12345";
        String customerName = "John Doe";
        String customerSlug = "john-doe";

        mockMvc.perform(MockMvcRequestBuilders.get("/next-tracking-number")
                        .param("origin_country_id", originCountryId)
                        .param("destination_country_id", destinationCountryId)
                        .param("weight", weight)
                        .param("created_at", createdAt)
                        .param("customer_id", customerId)
                        .param("customer_name", customerName)
                        .param("customer_slug", customerSlug)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}