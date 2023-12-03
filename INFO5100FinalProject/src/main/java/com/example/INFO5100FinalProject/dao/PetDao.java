package com.example.INFO5100FinalProject.dao;

import com.example.INFO5100FinalProject.model.Pet;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PetDao {

    int insertPet(UUID id, Pet pet);

    default int insertPet(Pet pet) {
        UUID id = UUID.randomUUID();
        return insertPet(id, pet);
    }

    List<Pet> selectAllPets();

    Optional<Pet> selectPetById(UUID id);

    int updatePetById(UUID id, Pet pet);

    int deletePetById(UUID id);
}
