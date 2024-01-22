package ru.stepagin.backend.exception;

public class BadSearchInputException extends Exception{
    public BadSearchInputException(String message) {
        super(message);
    }
}
