package com.ganeshtech.reviewplatform.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeRangeDTO {

@NotBlank(message = "OpenTime must provided")
@Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$\n",message = "Invalid time")
    private String openTime;
@Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$\n",message = "Invalid time")
    @NotBlank(message = "CloseTime must provided")
    private String closeTime;

}
