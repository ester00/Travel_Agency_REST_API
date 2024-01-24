package com.ester.travel.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationCreate {
    private Long id;
    private String contactName;
    private String phoneNumber;
    private Long holiday;
}