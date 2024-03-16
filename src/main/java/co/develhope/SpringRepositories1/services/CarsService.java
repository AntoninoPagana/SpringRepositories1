package co.develhope.SpringRepositories1.services;

import co.develhope.SpringRepositories1.entities.Cars;
import co.develhope.SpringRepositories1.repositories.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsService {
    
    @Autowired
    private CarsRepository carsRepository;

    public Cars addCar(Cars macchinaDaAggiungere) {
        Cars carAdded = carsRepository.save(macchinaDaAggiungere);
        return carAdded;
    }

    public List<Cars> getAllCar() {
        return carsRepository.findAll();
    }

    public Optional<Cars> getCar(Long id) {
        Optional<Cars> carFounded = carsRepository.findById(id);
        return carFounded;
    }

    public Optional<Cars> updateCar(Long id, Cars car) {
        Optional<Cars> carToUpdate = carsRepository.findById(id);
        if (carToUpdate.isPresent()) {
            carToUpdate.get().setModelName(car.getModelName());
            carToUpdate.get().setSerialNumber(car.getSerialNumber());
            carToUpdate.get().setCurrentPrice(car.getCurrentPrice());
            Cars carUpdated = carsRepository.save(carToUpdate.get());
            return Optional.of(carUpdated);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Cars> deleteCar(Long id) {
        Optional<Cars> carToDelete = carsRepository.findById(id);
        if (carToDelete.isPresent()) {
            carsRepository.delete(carToDelete.get());
        } else {
            return Optional.empty();
        }
        return carToDelete;
    }
}
