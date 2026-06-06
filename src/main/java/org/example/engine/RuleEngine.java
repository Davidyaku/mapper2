package org.example.engine;

import lombok.experimental.UtilityClass;
import org.example.rules.Rule;

import java.util.List;

/**
 * Applies a sequence of business rules to an entity.
 */
@UtilityClass
public final class RuleEngine {
    public static void applyAll(List<Rule<?>> rules) {
        for (Rule<?> rule : rules) {
            rule.apply();
        }
    }
}
