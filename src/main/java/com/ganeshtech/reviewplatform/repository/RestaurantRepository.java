package com.ganeshtech.reviewplatform.repository;

import com.ganeshtech.reviewplatform.domain.entities.Restaurant;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RestaurantRepository extends ElasticsearchRepository<Restaurant,String> {


}
