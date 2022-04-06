package com.service;

import com.Dog;
import com.DogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DogService {
    private DogRepository dogRepository;

    @Autowired
    DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog read(long id) {
        log.info("Read dog by id = {}", id);
        return dogRepository.findById(id).get();
    }

    public List<Dog> readAll() {
        log.info("Read all dogs");
        return dogRepository.findAll();
    }

    public void saveDog(Dog dog) {
        log.info("Save dog {}", dog);
        dogRepository.save(dog);
    }

    public boolean update(Dog dog, long id) {
        log.info("Update dog {} by id = {}", dog, id);
        dog.setId(id);
        dogRepository.save(dog);
        return true;
    }

    public boolean deleteDog(long id) {
        log.info("Delete dog by id = {}", id);
        dogRepository.deleteById(id);
        return true;
    }

    public List<Dog> findDogsByName(String name) {
        log.info("Find all dogs by name = {}", name);
        return dogRepository.findAllByName(name);
    }

    public List<Dog> findDogsByBreed(String breed) {
        log.info("Find all dogs by breed = {}", breed);
        return dogRepository.findAllByBreed(breed);
    }
}

