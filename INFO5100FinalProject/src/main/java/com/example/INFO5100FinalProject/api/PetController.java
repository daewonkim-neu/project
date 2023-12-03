package com.example.INFO5100FinalProject.api;

import com.example.INFO5100FinalProject.model.Pet;
import com.example.INFO5100FinalProject.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/pet")
@RestController
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public void addPet(@RequestBody Pet pet) {
        petService.insertPet(pet);
    }

    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping(path = "{id}")
    public Pet getPetById(@PathVariable("id") UUID id) {
        return petService.selectPetById(id)
                .orElse(null);
    }

    @PutMapping(path = "{id}")
    public int updatePetById(@PathVariable("id") UUID id, @RequestBody Pet pet) {
        return petService.updatePetById(id, pet);
    }

    @DeleteMapping(path = "{id}")
    public int deletePetById(@PathVariable("id") UUID id) {
        return petService.deletePetById(id);
    }
}
