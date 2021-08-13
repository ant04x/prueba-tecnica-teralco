package dev.ant04x.pruebatecnicateralco.repositories;

import dev.ant04x.pruebatecnicateralco.entities.Brand;
import dev.ant04x.pruebatecnicateralco.entities.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {
    Brand findBrandById(long id);
}
