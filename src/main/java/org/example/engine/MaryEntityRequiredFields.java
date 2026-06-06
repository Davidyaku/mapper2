package org.example.engine;

import lombok.experimental.UtilityClass;
import org.example.entities.MaryEntity;

import java.util.List;

@UtilityClass
public final class MaryEntityRequiredFields {
    public static List<RequiredField<MaryEntity, ?>> list() {
        return List.of(
                RequiredField.of("integer", MaryEntity::getInteger),
                RequiredField.of("string", MaryEntity::getString)
        );
    }
}
