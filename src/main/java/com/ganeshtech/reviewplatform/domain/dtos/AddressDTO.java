package com.ganeshtech.reviewplatform.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {
@NotBlank(message = "StreetName is required ")
    private String streetName;
    @NotBlank(message = "City is required")
    private String city;
   @NotBlank(message = "State is required")
    private String state;
    @NotBlank(message = "Postal Code is required")
    private String postalCode;
    @NotBlank(message = "Country is required")
    private String country;
   
    private String unit;
    @NotBlank(message = "Street number is required")
    @Pattern(
            regexp = "^[A-Za-z0-9/-]{1,10}$",
            message = "Invalid street number format"
    )
    private String streetNumber;
}
