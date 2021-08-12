package dev.ant04x.pruebatecnicateralco.configurations;

import dev.ant04x.pruebatecnicateralco.entities.Brand;
import dev.ant04x.pruebatecnicateralco.entities.Car;
import dev.ant04x.pruebatecnicateralco.entities.Price;
import dev.ant04x.pruebatecnicateralco.repositories.BrandRepository;
import dev.ant04x.pruebatecnicateralco.repositories.CarRepository;
import dev.ant04x.pruebatecnicateralco.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@Service
@Configurable
public class LoadDatabase {

    @Bean
    CommandLineRunner run(BrandRepository brands, CarRepository cars, PriceRepository prices) {

        List<Brand> insertingBrands = Arrays.asList(
                new Brand("Renault"),
                new Brand("Alpine"),
                new Brand("Fiat")
        );

        List<Car> insertingCars = Arrays.asList(
                new Car("Clio", "orange", insertingBrands.get(0)),
                new Car("A110", "blue", insertingBrands.get(1)),
                new Car("Tipo", "brown", insertingBrands.get(2))
        );

        List<Price> insertingPrices = Arrays.asList(
                new Price(new Timestamp(1565565807), new Timestamp(1597188207), 300000, insertingCars.get(1)), // 2019-2020
                new Price(new Timestamp(1597188207), new Timestamp(1628724207), 300000, insertingCars.get(1)), // 2020-2021
                new Price(new Timestamp(1123802607), new Timestamp(1597188207), 300000, insertingCars.get(0)) // 2005-2020
        );

        return args -> {
            brands.saveAll(insertingBrands);
            cars.saveAll(insertingCars);
            prices.saveAll(insertingPrices);
            System.out.println(brands.findAll());
        };
    }
}
