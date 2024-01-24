package com.ester.travel.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ester.travel.entity.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {

}
