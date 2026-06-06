package org.example.engine;

import java.util.Objects;
import java.util.function.Function;

/**
 * Represents a required field on an entity and exposes a getter to check its value.
 *
 * @param name   the required field name used for reporting
 * @param getter a function that retrieves the field value from the entity
 */
public record RequiredField<T, V>(String name, Function<T, V> getter) {
    public RequiredField {
        Objects.requireNonNull(name, "Field name must not be null");
        Objects.requireNonNull(getter, "Getter function must not be null");
    }

    public static <T, V> RequiredField<T, V> of(String name, Function<T, V> getter) {
        return new RequiredField<>(name, getter);
    }

    public boolean hasValue(T entity) {
        return entity != null && getter.apply(entity) != null;
    }
}
