package com.ganeshtech.reviewplatform.service;

import com.ganeshtech.reviewplatform.domain.GeoLocation;
import com.ganeshtech.reviewplatform.domain.entities.Address;

public interface GeoLocationService {
    GeoLocation geoLocate(Address address);
}
