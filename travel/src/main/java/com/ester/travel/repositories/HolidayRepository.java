package com.ester.travel.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ester.travel.entity.Holiday;

public interface HolidayRepository extends CrudRepository<Holiday, Long> {

}
