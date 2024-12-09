package com.tracking.generate.contoller;

import com.tracking.generate.contoller.request.ParcelRequest;
import com.tracking.generate.contoller.response.TrackingResponse;
import com.tracking.generate.mapper.TrackingMapper;
import com.tracking.generate.service.TrackingService;
import com.tracking.generate.validate.WeightConstraints;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.tracking.generate.constant.CommonConstant.ALLOW_ONLY_UPPERCASE;
import static com.tracking.generate.constant.CommonConstant.LENGTH_SHOULD_BE_2;

@RequestMapping("/next-tracking-number")
@RestController
@Validated
@Slf4j
public class TrackingController {

    @Autowired
    private TrackingService service;


    @GetMapping
    public CompletableFuture<TrackingResponse> generateTrackingNumber(@RequestParam("origin_country_id")
                                                       @NotBlank
                                                       @Length(min = 2, max = 2, message = LENGTH_SHOULD_BE_2)
                                                       @Pattern(regexp = "^[A-Z]+$", message = ALLOW_ONLY_UPPERCASE) String originCountryId,
                                                    @RequestParam("destination_country_id")
                                                   @NotBlank
                                                   @Length(min = 2, max = 2, message = LENGTH_SHOULD_BE_2)
                                                   @Pattern(regexp = "^[A-Z]+$", message = ALLOW_ONLY_UPPERCASE)
                                                   String destinationCountryId,
                                                    @RequestParam("weight") @NotNull(message = "Invalid Field") @Positive(message = "weight should be positive ") @Valid @WeightConstraints Double weight,
                                                    @RequestParam("created_at") @NotBlank(message = "Invalid date")  String createdAt,
                                                    @RequestParam("customer_id") @NotBlank(message = "Provide Customer Id") String customerId,
                                                    @RequestParam("customer_name") @NotBlank(message = "Provide CustomerName") String customerName,
                                                    @RequestParam("customer_slug") String customerSlug) throws ExecutionException, InterruptedException {
        ParcelRequest parcelRequest = TrackingMapper.INSTANCE.toCreateParcelRequest(originCountryId, destinationCountryId, weight, createdAt, customerId, customerName, customerSlug);
        log.info("ParcelRequest : {}", parcelRequest);
        CompletableFuture<TrackingResponse> trackingResponseCompletableFuture = service.generateTrackingNumber(parcelRequest);
        log.info("Response : {}", trackingResponseCompletableFuture.get());
        return trackingResponseCompletableFuture;
    }
}
