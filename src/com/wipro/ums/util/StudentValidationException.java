package com.wipro.ums.util;

public class StudentValidationException extends Exception {

    public StudentValidationException() {
        super("Invalid Student Details");
    }

    @Override
    public String toString() {
        return "Invalid Student Details";
}
}
