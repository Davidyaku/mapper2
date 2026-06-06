package org.example.engine;

import java.util.Objects;
import java.util.function.Function;

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
