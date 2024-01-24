package com.ester.travel.controllers;

import java.util.List;
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
import com.ester.travel.entity.HolidayGetDto;
import com.ester.travel.entity.Location;
import com.ester.travel.entity.Reservation;
import com.ester.travel.entity.ReservationCreate;
import com.ester.travel.entity.ReservationGet;
import com.ester.travel.repositories.HolidayRepository;
import com.ester.travel.repositories.LocationRepository;
import com.ester.travel.repositories.ReservationRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationRepository reservationRepository;
    private final HolidayRepository holidayRepository;
    private final LocationRepository locationRepository;

    @GetMapping
    public List<ReservationGet> getAll() {
        return StreamSupport//
                .stream(this.reservationRepository.findAll().spliterator(), false)//
                .map(h -> ReservationGet.fromReservation(h,
                        getById(h.getHolidayId())))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ReservationGet get(@PathVariable Long id) {

        Reservation r = this.reservationRepository.findById(id).orElse(null);
        HolidayGetDto h = getById(r.getHolidayId());
        return ReservationGet.fromReservation(r, h);
    }

    @PutMapping
    public Reservation edit(@RequestBody ReservationCreate dto) {
        return reservationRepository.save(Reservation.fromCreate(dto));

    }

    @PostMapping
    public Reservation create(@RequestBody ReservationCreate dto) {
        return reservationRepository.save(Reservation.fromCreate(dto));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        reservationRepository.deleteById(id);
    }

    private HolidayGetDto getById(Long id) {
        Holiday holiday = this.holidayRepository.findById(id).orElse(null);
        Location location = this.locationRepository.findById(holiday.getLocationId()).orElse(null);
        return HolidayGetDto.fromEntity(holiday, location);

    }
}
