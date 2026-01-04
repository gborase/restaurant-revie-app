package com.ganeshtech.reviewplatform.domain.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantCreateUpdateDTO {
    @NotBlank(message = "Restarent name is required ")
    private String name;
    @NotBlank(message = "CuisineType  is required ")
    private String cuisineType;
    @NotBlank(message = "ContactInformation  is required ")
    private String contactInformation;
@Valid
    private AddressDTO address;
@Valid
    private OperatingHourDTO operatingHours;
@Size(min=1,message = "Atleast 1 photo ID is required ")
    private List<String> photoId;

}
