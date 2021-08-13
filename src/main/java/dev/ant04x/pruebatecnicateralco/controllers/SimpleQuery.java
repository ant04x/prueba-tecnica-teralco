package dev.ant04x.pruebatecnicateralco.controllers;

import dev.ant04x.pruebatecnicateralco.entities.Brand;
import dev.ant04x.pruebatecnicateralco.entities.Car;
import dev.ant04x.pruebatecnicateralco.entities.Price;
import dev.ant04x.pruebatecnicateralco.repositories.CarRepository;
import dev.ant04x.pruebatecnicateralco.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@RestController
public class SimpleQuery {

    private PriceRepository priceRepository;
    private CarRepository carRepository;

    @Autowired
    public void init(PriceRepository priceRepository, CarRepository carRepository) {
        this.priceRepository = priceRepository;
        this.carRepository = carRepository;
    }

    @GetMapping("/price/{currentDate}/{id}/")
    public ResponseEntity<Object> simpleQuery(@PathVariable("currentDate") String currentDate, @PathVariable("id") Long id) {

        Map<String, Object> map = new HashMap<>();

        try {
            Car car = carRepository.findCarById(id);

            Brand brand = car.getCarBrandIdFk();

            long timestampValue = Long.parseLong(currentDate);
            Timestamp timestamp = new Timestamp(timestampValue);

            Price price = priceRepository.findByPriceCarIdFkAndStartTimeIsLessThanAndEndTimeIsGreaterThan(
                    car,
                    timestamp,
                    timestamp
            );

            map.put("car_id", car.getId());
            map.put("brand_id", brand.getId());
            map.put("price_id", price.getId());
            map.put("price_cost", price.getCost());
            map.put("price_start_time", price.getStartTime());
            map.put("price_end_time", price.getEndTime());

            return new ResponseEntity<>(map, HttpStatus.OK);

        } catch (NullPointerException | NumberFormatException e) {

            map.clear();
            map.put("message", "Sorry, the object has not found.");
            map.put("error", e.getMessage()); // COMMENT In production is dangerous

            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }
}
