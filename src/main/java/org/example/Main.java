package org.example;

import org.example.database.DBMock;
import org.example.entities.DBEntity;
import org.example.entities.MaryEntity;
import org.example.engine.MaryEntityRequiredFields;
import org.example.engine.RequiredFieldValidator;
import org.example.mapper.DBEntityMapper;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<DBEntity> dbEntities = DBMock.getAllEntities();

        System.out.println("BEFORE");
        System.out.println("------------------------------------------");
        System.out.println(dbEntities.size() + " Entities");
        System.out.println(dbEntities);
        System.out.println("------------------------------------------\n");

        List<MaryEntity> maryEntities = dbEntities.stream()
                .map(DBEntityMapper.INSTANCE::toMaryEntity)
                .filter(RequiredFieldValidator.filterByRequiredFieldsAndLog(MaryEntityRequiredFields.list()))
                .collect(Collectors.toList());

        System.out.println("AFTER FILTERING REQUIRED FIELDS");
        System.out.println("------------------------------------------");
        System.out.println(maryEntities.size() + " Entities");
        System.out.println(maryEntities);
        System.out.println("------------------------------------------\n");
    }
}
