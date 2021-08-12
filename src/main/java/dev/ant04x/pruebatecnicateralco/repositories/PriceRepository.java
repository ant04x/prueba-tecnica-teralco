package dev.ant04x.pruebatecnicateralco.repositories;

import dev.ant04x.pruebatecnicateralco.entities.Car;
import dev.ant04x.pruebatecnicateralco.entities.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {
    Price findByPriceCarIdFkAndStartTimeIsLessThanAndEndTimeIsGreaterThan(Car priceCarIdFk, Timestamp startTime, Timestamp endTime);
}
