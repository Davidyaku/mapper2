package org.example.rules;

import org.example.entities.Structure;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class StructureRule extends Rule<Structure> {
    private static final int NAME_MIN_LENGTH = 3;
    private static final int NAME_MAX_LENGTH = 20;

    public StructureRule(Supplier<Structure> getter, Consumer<Structure> setter) {
        super(getter, setter);
    }

    @Override
    public void apply() {
        Structure structure = getGetter().get();
        if (structure == null) {
            return;
        }

        String name = structure.getName();
        if (name == null || name.length() < NAME_MIN_LENGTH) {
            getSetter().accept(null);
            return;
        }

        if (name.length() > NAME_MAX_LENGTH) {
            structure.setName(name.substring(0, NAME_MAX_LENGTH));
        }
    }
}
