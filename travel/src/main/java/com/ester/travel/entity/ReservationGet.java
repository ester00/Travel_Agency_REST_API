package com.ester.travel.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationGet {
    private Long id;
    private String contactName;
    private String phoneNumber;
    private HolidayGetDto holiday;

    public static ReservationGet fromReservation(Reservation r, HolidayGetDto h) {
        return ReservationGet.builder()//
                .id(r.getId())
                .contactName(r.getContactName())
                .phoneNumber(r.getPhoneNumber())
                .holiday(h)
                .build();
    }
}
