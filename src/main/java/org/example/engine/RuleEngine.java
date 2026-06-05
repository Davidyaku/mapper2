package org.example.engine;

import lombok.experimental.UtilityClass;
import org.example.rules.Rule;

import java.util.List;

@UtilityClass
public final class RuleEngine {
    public static void applyAll(List<Rule> rules) {
        for (Rule<?> rule : rules) {
            rule.apply();
        }
    }
}
