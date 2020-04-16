package com.ea.miushop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "storage_movements")
@Entity
public class StorageMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storageMovementId;

    @Column(nullable = false)
    private StorageMovementType storageMovementType;

//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime movementDate;

    @Column(nullable = false)
    private Integer quantity;

    public StorageMovement() {
    }

    public Long getStorageMovementId() {
        return storageMovementId;
    }

    public void setStorageMovementId(Long storageMovementId) {
        this.storageMovementId = storageMovementId;
    }

    public StorageMovementType getStorageMovementType() {
        return storageMovementType;
    }

    public void setStorageMovementType(StorageMovementType storageMovementType) {
        this.storageMovementType = storageMovementType;
    }

    public LocalDateTime getMovementDate() {
        return movementDate;
    }

    public void setMovementDate(LocalDateTime movementDate) {
        this.movementDate = movementDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
