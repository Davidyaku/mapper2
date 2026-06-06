package org.example.engine;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@UtilityClass
public final class RequiredFieldValidator {
    public static <T> List<String> getMissingRequiredFieldNames(T entity, List<RequiredField<T, ?>> requiredFields) {
        if (entity == null) {
            return List.of();
        }

        return requiredFields.stream()
                .filter(requiredField -> !requiredField.hasValue(entity))
                .map(RequiredField::name)
                .collect(Collectors.toList());
    }

    public static <T> Predicate<T> filterByRequiredFieldsAndLog(List<RequiredField<T, ?>> requiredFields) {
        return (T entity) -> {
            List<String> missingFields = getMissingRequiredFieldNames(entity, requiredFields);

            if (!missingFields.isEmpty()) {
                System.out.println("Filtered entity: " + entity + " because missing required fields: " + missingFields);

                return false;
            }

            return true;
        };
    }
}
