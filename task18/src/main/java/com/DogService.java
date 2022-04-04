package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {
    private DogRepository dogRepository;

    @Autowired
    DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Dog read(long id){
        return dogRepository.getById(id);
    }

    public List<Dog> readAll() {
        return dogRepository.findAll();
    }

    public void saveDog(Dog dog){
        dogRepository.save(dog);
    }

    boolean update(Dog dog, long id) {
        dog.setId(id);
        dogRepository.save(dog);
        return true;
    }

    public boolean deleteDog(long id){
        dogRepository.deleteById(id);
        return true;
    }

    List<Dog> findDogsByName(String name){
        return dogRepository.findAllByName(name);
    }

    List<Dog> findDogsByBreed(String breed){
        return dogRepository.findAllByBreed(breed);
    }
}

