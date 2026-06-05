package org.example.rules;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class NumberRangeRule extends Rule<Number> {
    private final double minValue;
    private final double maxValue;

    public NumberRangeRule(Supplier<Number> getter, Consumer<Number> setter, double minValue, double maxValue) {
        super(getter, setter);

        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public void apply() {
        Number value = getGetter().get();
        if (value == null) {
            return;
        }

        double numericValue = value.doubleValue();
        if (numericValue > maxValue) {
            getSetter().accept(maxValue);
        } else if (numericValue < minValue) {
            getSetter().accept(null);
        }
    }
}
