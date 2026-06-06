package org.example.engine;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Provides required-field validation helpers and filtering predicates.
 */
@UtilityClass
public final class RequiredFieldValidator {
    /**
     * Returns the names of required fields that are missing from the given entity.
     *
     * @param entity         entity to validate
     * @param requiredFields required fields to check
     * @param <T>            entity type
     * @return list of missing required field names
     */
    public static <T> List<String> getMissingRequiredFieldNames(T entity, List<RequiredField<T, ?>> requiredFields) {
        if (entity == null) {
            return List.of();
        }

        return requiredFields.stream()
                .filter((RequiredField<T, ?> requiredField) -> !requiredField.hasValue(entity))
                .map(RequiredField::name)
                .collect(Collectors.toList());
    }

    /**
     * Creates a predicate that filters entities missing required fields and logs the filtering reason.
     *
     * @param requiredFields required fields to validate
     * @param <T>            entity type
     * @return predicate returning true when all required fields are present
     */
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
