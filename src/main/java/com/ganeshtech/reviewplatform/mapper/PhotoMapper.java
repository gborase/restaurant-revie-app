package com.ganeshtech.reviewplatform.mapper;

import com.ganeshtech.reviewplatform.domain.dtos.PhotoDto;
import com.ganeshtech.reviewplatform.domain.entities.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PhotoMapper {
    PhotoDto toDto(Photo photo);

}
