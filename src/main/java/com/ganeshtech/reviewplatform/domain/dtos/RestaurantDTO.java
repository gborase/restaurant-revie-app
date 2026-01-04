package com.ganeshtech.reviewplatform.domain.dtos;

import com.ganeshtech.reviewplatform.domain.entities.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantDTO {
    
    private String id;
    private String name;
    private String cuisineType;
    private String contactInformation;
    private Float averageRating;
    private GeoPointDTO geoLocation;
    private AddressDTO address;
    private OperatingHourDTO operatingHours;
    private List<PhotoDto> photos = new ArrayList<>();
    private List<ReviewDTO> reviews = new ArrayList<>();
    private UserDTO createdBy;
}
