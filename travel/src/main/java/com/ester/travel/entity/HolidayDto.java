package com.ester.travel.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HolidayDto {

    private Long id;
    private Integer duration;
    private Integer freeSlots;
    private Long location;
    private String price;
    private String startDate;
    private String title;
}
