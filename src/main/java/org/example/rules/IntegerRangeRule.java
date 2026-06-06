package org.example.rules;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Validates an {@link Integer} value and enforces a minimum and maximum bound.
 */
public class IntegerRangeRule extends Rule<Integer> {
    private final int minValue;
    private final int maxValue;

    public IntegerRangeRule(Supplier<Integer> getter, Consumer<Integer> setter, int minValue, int maxValue) {
        super(getter, setter);
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public void apply() {
        Integer value = getGetter().get();
        if (value == null) {
            return;
        }

        if (value > maxValue) {
            getSetter().accept(maxValue);
        } else if (value < minValue) {
            getSetter().accept(null);
        }
    }
}
