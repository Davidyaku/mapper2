package org.example.rules;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Validates a string's length and truncates or clears it when it is out of range.
 */
public class StringLengthRule extends Rule<String> {
    private final int minLength;
    private final int maxLength;

    public StringLengthRule(Supplier<String> getter, Consumer<String> setter, int minLength, int maxLength) {
        super(getter, setter);
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public void apply() {
        String value = getGetter().get();
        if (value == null) {
            return;
        }

        if (value.length() > maxLength) {
            getSetter().accept(value.substring(0, maxLength));
        } else if (value.length() < minLength) {
            getSetter().accept(null);
        }
    }
}
