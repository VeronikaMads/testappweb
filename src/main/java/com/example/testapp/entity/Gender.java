package com.example.testapp.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
@Getter
@RequiredArgsConstructor
public enum Gender {
    MALE(Values.MALE),
    FEMALE(Values.FEMALE);

    private static final Map<String, Gender> MAP = Arrays.stream(Gender.values())
            .collect(Collectors.toMap(Gender::getValue, Function.identity()));

    private final String value;

    public static Gender getByValue(String value) {
        if (Objects.isNull(value)) {
            return null;
        }
        return MAP.get(value);
    }

    public static class Values {
        public static final String MALE = "Male";
        public static final String FEMALE = "Female";
    }
}
