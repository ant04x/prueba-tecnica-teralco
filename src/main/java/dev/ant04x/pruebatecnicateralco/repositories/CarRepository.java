package dev.ant04x.pruebatecnicateralco.repositories;

import dev.ant04x.pruebatecnicateralco.entities.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    Car findCarById(long id);
}
