package com.tracking.generate.contoller.request;

import com.tracking.generate.validate.WeightConstraints;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

import static com.tracking.generate.constant.CommonConstant.ALLOW_ONLY_UPPERCASE;
import static com.tracking.generate.constant.CommonConstant.LENGTH_SHOULD_BE_2;

@Getter
@Setter
@ToString
public class ParcelRequest {
    private String originCountryId;

    private String destinationCountryId;
    private Double weight;
    private String createdAt;
    private String customerId;
    private String customerName;
    private String customerSlug;

}
