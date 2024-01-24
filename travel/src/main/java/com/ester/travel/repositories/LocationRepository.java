package com.ester.travel.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ester.travel.entity.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

}
