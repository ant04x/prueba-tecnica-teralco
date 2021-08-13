package dev.ant04x.pruebatecnicateralco.controllers;

import dev.ant04x.pruebatecnicateralco.entities.Car;
import dev.ant04x.pruebatecnicateralco.repositories.BrandRepository;
import dev.ant04x.pruebatecnicateralco.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FilteredQuery {

    private CarRepository carRepository;
    private BrandRepository brandRepository;

    @Autowired
    public void init(CarRepository carRepository, BrandRepository brandRepository) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
    }

    @GetMapping("/cars")
    public List<Car> filteredQuery(
            @RequestParam String selColumn,
            @RequestParam String filter,
            @RequestParam String value
    ) {
        List<Car> result = new ArrayList<>();

        try {

            switch (selColumn) {
                case "id":
                    long parsedIdValue = Long.parseLong(value);
                    switch (filter) {
                        case "eq":
                            result.add(carRepository.findCarById(parsedIdValue));
                            return result;
                        case "lt":
                            return carRepository.findByIdLessThan(parsedIdValue);
                        case "gt":
                            return carRepository.findByIdGreaterThan(parsedIdValue);
                        default:
                            throw new InvalidParameterException();
                    }
                case "modelName":
                    switch (filter) {
                        case "eq":
                            return carRepository.findByModelNameEquals(value);
                        case "lt":
                            return carRepository.findByModelNameLessThan(value);
                        case "gt":
                            return carRepository.findByModelNameGreaterThan(value);
                        default:
                            throw new InvalidParameterException();
                    }
                case "colorName":
                    switch (filter) {
                        case "eq":
                            return carRepository.findByColorNameEquals(value);
                        case "lt":
                            return carRepository.findByColorNameLessThan(value);
                        case "gt":
                            return carRepository.findByColorNameGreaterThan(value);
                        default:
                            throw new InvalidParameterException();
                    }
                default:
                    throw new InvalidParameterException();
            }

        } catch (InvalidParameterException e) { return null; }
    }
}
