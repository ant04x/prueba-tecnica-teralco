package dev.ant04x.pruebatecnicateralco.controllers;

import dev.ant04x.pruebatecnicateralco.entities.Brand;
import dev.ant04x.pruebatecnicateralco.entities.Car;
import dev.ant04x.pruebatecnicateralco.entities.Price;
import dev.ant04x.pruebatecnicateralco.repositories.CarRepository;
import dev.ant04x.pruebatecnicateralco.repositories.PriceRepository;
import dev.ant04x.pruebatecnicateralco.responses.PriceByCarAndDateObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class SimpleQuery {

    // @Autowired
    PriceRepository priceRepository;
    // @Autowired
    CarRepository carRepository;

    @GetMapping("/{currentDate}/{id}/")
    public PriceByCarAndDateObject simpleQuery(@PathVariable("currentDate") Timestamp currentDate, @PathVariable("id") long id) {

        Car car = carRepository.findCarById(id);

        Brand brand = car.getCarBrandIdFk();

        Price price = priceRepository.findByPriceCarIdFkAndStartTimeIsLessThanAndEndTimeIsGreaterThan(
                car,
                currentDate,
                currentDate
        );

        return new PriceByCarAndDateObject(
                car.getId(),
                brand.getId(),
                price.getId(),
                price.getCost(),
                price.getStartTime(),
                price.getEndTime()
        );
    }
}
