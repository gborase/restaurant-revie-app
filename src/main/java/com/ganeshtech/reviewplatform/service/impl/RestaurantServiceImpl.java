package com.ganeshtech.reviewplatform.service.impl;

import com.ganeshtech.reviewplatform.domain.GeoLocation;
import com.ganeshtech.reviewplatform.domain.RestaurantCreateUpdateRequest;
import com.ganeshtech.reviewplatform.domain.entities.Address;
import com.ganeshtech.reviewplatform.domain.entities.Photo;
import com.ganeshtech.reviewplatform.domain.entities.Restaurant;
import com.ganeshtech.reviewplatform.repository.RestaurantRepository;
import com.ganeshtech.reviewplatform.service.GeoLocationService;
import com.ganeshtech.reviewplatform.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final GeoLocationService geoLocationService;
    private final RestaurantRepository restaurantRepository;
    @Override
    public Restaurant createRestaurant(RestaurantCreateUpdateRequest request) {
        Address address = request.getAddress();
        GeoLocation geoLocation = geoLocationService.geoLocate(address);
        GeoPoint geoPoint = new GeoPoint(geoLocation.getLatitude(), geoLocation.getLongitude());
        List<String> photoIds = request.getPhotoId();

        List<Photo> list = photoIds.stream().map(photoUrl -> Photo
                .builder()
                .url(photoUrl)
                .uploadDate(LocalDateTime.now())
                .build()).toList();

        Restaurant build = Restaurant.builder()
                .name(request.getName())
                .cuisineType(request.getCuisineType())
                .contactInformation(request.getContactInformation())
                .geoLocation(geoPoint)
                .operatingHours(request.getOperatingHours())
                .averageRating(0f)
                .photos(list)
                .build();
        return restaurantRepository.save(build);

    }
}
