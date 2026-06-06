package org.example.database;

import lombok.experimental.UtilityClass;
import org.example.entities.DBEntity;
import org.example.entities.Structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@UtilityClass
public class DBMock {
    public static List<DBEntity> getAllEntities() {
        return List.of(
                createEntity(),
                createEntityWithNullRequiredFields(),
                createEntityWithNullInteger(),
                createEntityWithNullString()
        );
    }

    private static DBEntity createEntity() {
        Random random = new Random();
        return createEntity(random, false, false);
    }

    private static DBEntity createEntityWithNullRequiredFields() {
        Random random = new Random();
        return createEntity(random, true, true);
    }

    private static DBEntity createEntityWithNullInteger() {
        Random random = new Random();
        return createEntity(random, true, false);
    }

    private static DBEntity createEntityWithNullString() {
        Random random = new Random();
        return createEntity(random, false, true);
    }

    private static DBEntity createEntity(Random random, boolean nullInteger, boolean nullString) {
        return DBEntity.builder()
                .integer(nullInteger ? null : random.nextInt())
                .aLong(random.nextLong())
                .number(random.nextInt())
                .structure(getStructure(random))
                .string(nullString ? null : Objects.toString(random.nextInt()))
                .build();
    }

    private static Structure getStructure(Random random) {
        return Structure.builder()
                .list(new ArrayList<>())
                .name(Objects.toString(random.nextInt()))
                .build();
    }
}
