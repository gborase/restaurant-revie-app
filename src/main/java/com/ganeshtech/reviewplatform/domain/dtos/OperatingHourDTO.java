package com.ganeshtech.reviewplatform.domain.dtos;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperatingHourDTO {

@Valid
    private TimeRangeDTO monday;
@Valid
    private TimeRangeDTO tuesday;
@Valid
    private TimeRangeDTO wednesday;
@Valid
    private TimeRangeDTO thursday;
@Valid
    private TimeRangeDTO friday;
    @Valid
    private TimeRangeDTO saturday;
    @Valid
    private TimeRangeDTO sunday;
}
