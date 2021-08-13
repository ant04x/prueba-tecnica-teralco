package dev.ant04x.pruebatecnicateralco.repositories;

import dev.ant04x.pruebatecnicateralco.entities.Brand;
import dev.ant04x.pruebatecnicateralco.entities.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    Car findCarById(long id);
    List<Car> findByIdGreaterThan(long idComparing);
    List<Car> findByIdLessThan(long idComparing);

    List<Car> findByModelNameEquals(String nameComparing);
    List<Car> findByModelNameGreaterThan(String nameComparing);
    List<Car> findByModelNameLessThan(String nameComparing);

    List<Car> findByColorNameEquals(String nameComparing);
    List<Car> findByColorNameGreaterThan(String nameComparing);
    List<Car> findByColorNameLessThan(String nameComparing);
}
