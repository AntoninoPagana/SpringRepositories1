package co.develhope.SpringRepositories1.repositories;

import co.develhope.SpringRepositories1.entities.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Long> {
}
