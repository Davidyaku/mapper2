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
        return List.of(createEntity(), createEntity(), createEntity());
    }

    private static DBEntity createEntity() {
        Random random = new Random();

        return DBEntity.builder()
                .integer(random.nextInt())
                .aLong(random.nextLong())
                .number(random.nextInt())
                .structure(getStructure(random))
                .string(Objects.toString(random.nextInt()))
                .build();
    }

    private static Structure getStructure(Random random) {
        return Structure.builder()
                .list(new ArrayList<>())
                .name(Objects.toString(random.nextInt()))
                .build();
    }
}
