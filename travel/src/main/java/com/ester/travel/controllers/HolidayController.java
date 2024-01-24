package com.ester.travel.controllers;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ester.travel.entity.Holiday;
import com.ester.travel.entity.HolidayDto;
import com.ester.travel.entity.HolidayGetDto;
import com.ester.travel.entity.Location;
import com.ester.travel.repositories.HolidayRepository;
import com.ester.travel.repositories.LocationRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/holidays")
@RequiredArgsConstructor
public class HolidayController {
    private final HolidayRepository holidayRepository;
    private final LocationRepository locationRepository;

    @PostMapping
    public Holiday create(@RequestBody HolidayDto holiday) {
        return holidayRepository.save(Holiday.fromDto(holiday));
    }

    @PutMapping
    public Holiday edit(@RequestBody HolidayDto holiday) {
        return holidayRepository.save(Holiday.fromDto(holiday));
    }

    @GetMapping("/{id}")
    public HolidayGetDto getById(@PathVariable Long id) {

        Holiday holiday = this.holidayRepository.findById(id).orElse(null);
        Location location = this.locationRepository.findById(holiday.getLocationId()).orElse(null);
        return HolidayGetDto.fromEntity(holiday, location);

    }

    @GetMapping
    public java.util.List<HolidayGetDto> getHolidays() {
        return StreamSupport//
                .stream(this.holidayRepository.findAll().spliterator(), false)//
                .map(h -> HolidayGetDto.fromEntity(h, this.locationRepository.findById(h.getLocationId()).orElse(null)))
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        holidayRepository.deleteById(id);
    }
}
