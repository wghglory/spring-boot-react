package com.guanghui.springbootreact.repository;

import com.guanghui.springbootreact.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@RepositoryRestResource(path = "vehicles") // spring-boot-starter-data-rest
@RepositoryRestResource // // spring-boot-starter-data-rest
public interface CarRepository extends JpaRepository<Car, Long> {
    // spring-boot-starter-data-rest needs @Param then, we can search by
    // http://localhost:8081/api/v1/cars/search/findByBrand?brand=Toyota
    List<Car> findByBrand(@Param("brand") String brand);

    @Query("select c from Car c where c.brand = ?1")
    List<Car> getByBrand(@Param("brand") String brand);

    List<Car> findByColor(@Param("color") String color);

    List<Car> findByYear(@Param("year") Integer year);

    List<Car> findByBrandAndModel(@Param("brand") String brand, @Param("model") String model);

    List<Car> findByBrandOrColor(@Param("brand") String brand, @Param("color") String color);

    List<Car> findByBrandOrderByYearAsc(@Param("brand") String brand);

    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndsWith(@Param("brand") String brand);
}
