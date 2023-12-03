package com.example.INFO5100FinalProject.repository;

import com.example.INFO5100FinalProject.dao.PetDao;
import com.example.INFO5100FinalProject.model.Pet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PetRepository implements PetDao {
    private static List<Pet> petDB = new ArrayList<>();

    @Override
    public int insertPet(UUID id, Pet pet) {
        petDB.add(new Pet(id, pet.getName(), pet.getBreed(), pet.getWeight(), pet.getDob(), pet.getDetail(), pet.getUserName()));
        return 1;
    }

    @Override
    public List<Pet> selectAllPets() {
        return petDB;
    }

    @Override
    public Optional<Pet> selectPetById(UUID id) {
        return petDB.stream()
                .filter(pet -> pet.getId().equals(id))
                .findFirst();
    }

    @Override
    public int updatePetById(UUID id, Pet petUpdateRequest) {
        return selectPetById(id)
                .map(usr -> {
                    int idxToUpdate = petDB.indexOf(usr);
                    if (idxToUpdate >= 0) {
                        petDB.set(idxToUpdate, new Pet(id, petUpdateRequest.getName(), petUpdateRequest.getBreed(), petUpdateRequest.getWeight(), petUpdateRequest.getDob(), petUpdateRequest.getDetail(), petUpdateRequest.getUserName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int deletePetById(UUID id) {
        Optional<Pet> pet = selectPetById(id);
        if (pet.isEmpty()) return 0;
        petDB.remove(pet.get());

        return 1;
    }
}
