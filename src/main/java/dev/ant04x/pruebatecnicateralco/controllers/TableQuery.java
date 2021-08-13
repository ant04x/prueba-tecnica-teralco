package dev.ant04x.pruebatecnicateralco.controllers;

import dev.ant04x.pruebatecnicateralco.entities.Car;
import dev.ant04x.pruebatecnicateralco.repositories.CarRepository;
import dev.ant04x.pruebatecnicateralco.utils.ExcelMaterializer;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
public class TableQuery {

    CarRepository carRepository;

    @Autowired
    public void init(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/download/cars")
    public ResponseEntity<Object> tableQuery() {

        List<Car> carList = (List<Car>) carRepository.findAll();

        try {
            ByteArrayInputStream in = ExcelMaterializer.carsToExcel(carList);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=cars.xlsx");

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .body(new InputStreamResource(in));

        } catch (IOException e) {

            return ResponseEntity
                    .internalServerError().body(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/download/cars"));
        }
    }
}
