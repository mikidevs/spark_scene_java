package com.mikidevs.sparkscene.shared;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.validation.FieldError;

import org.springframework.validation.BindingResult;

public class FormUtil {
    public static Map<String, String> getErrorMap(BindingResult bindingResult) {
        return
        bindingResult.getFieldErrors().stream()
            .collect(Collectors.groupingBy(
                FieldError::getField,
                Collectors.mapping(
                    FieldError::getDefaultMessage, 
                    Collectors.toList()
                )
            )).entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().get(0)
            ));
    }
}
