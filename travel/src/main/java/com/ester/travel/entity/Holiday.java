package com.ester.travel.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

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
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(name = "startDate")
    private LocalDate startDate;
    private Integer duration;
    private BigDecimal price;
    @Column(name = "freeSlots")
    private Integer freeSlots;

    @Column(name = "location_id")
    private Long locationId;

    public static Holiday fromDto(HolidayDto dto) {
        return Holiday.builder()//
                .id(dto.getId())
                .duration(dto.getDuration())
                .freeSlots(dto.getFreeSlots())
                .price(new BigDecimal(dto.getPrice()))
                .startDate(LocalDate.parse(dto.getStartDate()))
                .title(dto.getTitle())
                .locationId(dto.getLocation())
                .build();
    }
}
