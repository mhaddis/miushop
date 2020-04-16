package com.ea.miushop.controller;

import com.ea.miushop.domain.StorageMovement;
import com.ea.miushop.service.StorageMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movements")
public class StorageMovementController {

    @Autowired
    StorageMovementService storageMovementService;

    @GetMapping(value = "all")
    public List<StorageMovement> getAllStorageMovements(){
        return storageMovementService.getAllStorageMovements();
    }

    @GetMapping(value = "{storageMovementId}")
    public StorageMovement getStorageMovementById(@PathVariable Long storageMovementId){
        return storageMovementService.getStorageMovement(storageMovementId);
    }

    @PostMapping(value = "new-storageMovement", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    public void makeStorageMovement(@RequestBody StorageMovement storageMovement){
        storageMovementService.makeStorageMovement(storageMovement);
    }
}