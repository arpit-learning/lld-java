package com.example.designPatterns.creationalDesignPatterns.builder.validators;

import java.util.regex.Pattern;

public class EmailValidator {
    private static final Pattern EMAIL_REGEX =
            Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");

    public static boolean isValid(String email) {
        return EMAIL_REGEX.matcher(email).matches();
    }
}
