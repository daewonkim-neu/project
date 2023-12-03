package com.example.INFO5100FinalProject.service;

import com.example.INFO5100FinalProject.dao.PetDao;
import com.example.INFO5100FinalProject.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PetService {
    private final PetDao petDao;

    @Autowired
    public PetService(PetDao petDao) {
        this.petDao = petDao;
    }

    public int insertPet(Pet pet) {
        return petDao.insertPet(pet);
    }

    public List<Pet> getAllPets() {
        return petDao.selectAllPets();
    }

    public Optional<Pet> selectPetById(UUID id) {
        return petDao.selectPetById(id);
    }

    public int updatePetById(UUID id, Pet pet) {
        return petDao.updatePetById(id, pet);
    }

    public int deletePetById(UUID id) {
        return petDao.deletePetById(id);
    }
}
