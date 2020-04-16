package com.ea.miushop.service.impl;

import com.ea.miushop.domain.StorageMovement;
import com.ea.miushop.repository.StorageMovementRepository;
import com.ea.miushop.service.StorageMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StorageMovementServiceImpl implements StorageMovementService {

    @Autowired
    StorageMovementRepository storageMovementRepository;

    @Override
    public List<StorageMovement> getAllStorageMovements() {
        return storageMovementRepository.findAll();
    }

    @Override
    public StorageMovement getStorageMovement(Long id) {
        return storageMovementRepository.findById(id).get();
    }

    @Override
    public void makeStorageMovement(StorageMovement storageMovement) {
        storageMovementRepository.save(storageMovement);
    }
}
