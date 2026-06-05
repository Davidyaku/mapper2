package org.example.engine;

import lombok.experimental.UtilityClass;
import org.example.entities.MaryEntity;
import org.example.rules.*;

import java.util.List;

@UtilityClass
public final class MaryEntityRules {
    public static List<Rule> rules(MaryEntity maryEntity) {
        return List.of(
                new IntegerRangeRule(maryEntity::getInteger, maryEntity::setInteger, 3, 100),
                new StringLengthRule(maryEntity::getString, maryEntity::setString, 0, 2),
                new LongRangeRule(maryEntity::getALong, maryEntity::setALong, 0L, 1000L),
                new NumberRangeRule(maryEntity::getNumber, maryEntity::setNumber, 0.0, 10000.0),
                new StructureRule(maryEntity::getStructure2, maryEntity::setStructure2)
        );
    }
}
