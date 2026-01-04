package com.ganeshtech.reviewplatform.service;

import com.ganeshtech.reviewplatform.domain.RestaurantCreateUpdateRequest;
import com.ganeshtech.reviewplatform.domain.entities.Restaurant;

public interface RestaurantService {
    Restaurant createRestaurant(RestaurantCreateUpdateRequest request);
}
