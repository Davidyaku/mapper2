package org.example.rules;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Validates a {@link Long} value and enforces a minimum and maximum bound.
 */
public class LongRangeRule extends Rule<Long> {
    private final long minValue;
    private final long maxValue;

    public LongRangeRule(Supplier<Long> getter, Consumer<Long> setter, long minValue, long maxValue) {
        super(getter, setter);
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public void apply() {
        Long value = getGetter().get();
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
