package com.ester.travel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "contactName")
    private String contactName;
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "holiday_id")
    private Long holidayId;

    public static Reservation fromCreate(ReservationCreate create) {
        return Reservation.builder()//
                .id(create.getId())
                .contactName(create.getContactName())
                .phoneNumber(create.getPhoneNumber())
                .holidayId(create.getHoliday())
                .build();
    }
}
