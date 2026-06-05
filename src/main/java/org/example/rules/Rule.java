package org.example.rules;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Getter
@Setter
@AllArgsConstructor
public abstract class Rule<T> {
    private final Supplier<T> getter;
    private final Consumer<T> setter;

    public abstract void apply();
}
