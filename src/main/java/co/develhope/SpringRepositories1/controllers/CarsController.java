package co.develhope.SpringRepositories1.controllers;

import co.develhope.SpringRepositories1.entities.Cars;
import co.develhope.SpringRepositories1.services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v")
public class CarsController {
    @Autowired
    private CarsService carsService;

    @PostMapping("/create")
    public ResponseEntity<Cars> addCar(@RequestBody Cars car) {
        Cars carToAdd = carsService.addCar(car);
        return ResponseEntity.ok().body(carToAdd);
    }

    @GetMapping("/read")
    public ResponseEntity<Cars> getCar(@PathVariable Long id) {
        Optional<Cars> carToRead = carsService.getCar(id);
        return ResponseEntity.ok().body(carToRead.get());
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<Cars>> getCar() {
        return ResponseEntity.ok().body(carsService.getAllCar());
    }

    @PutMapping("/update")
    public ResponseEntity<Cars> updateCar(@PathVariable Long id, @RequestBody Cars car) {
        Optional<Cars> carToUpdate = carsService.updateCar(id, car);
        return ResponseEntity.ok().body(carToUpdate.get());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Cars> deleteCar(@PathVariable Long id) {
        Optional<Cars> carToDelete = carsService.deleteCar(id);
        return ResponseEntity.ok().body(carToDelete.get());
    }
}
