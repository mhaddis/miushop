package com.ea.miushop.domain.converter;

import com.ea.miushop.domain.StorageMovementType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StorageMovementTypeConverter implements AttributeConverter<StorageMovementType, String> {

    @Override
    public String convertToDatabaseColumn(StorageMovementType storageMovementType) {
        switch (storageMovementType) {
            case IN:
                return "I";
            case OUT:
                return "O";
            default:
                throw new IllegalArgumentException("Unknown value: " + storageMovementType);
        }
    }

    @Override
    public StorageMovementType convertToEntityAttribute(String fromDatabase) {
        switch (fromDatabase) {
            case "I":
                return StorageMovementType.IN;
            case "O":
                return StorageMovementType.OUT;
            default:
                throw new IllegalArgumentException("Unknown value: " + fromDatabase);
        }
    }

}
