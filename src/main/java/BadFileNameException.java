package main.java;

public class BadFileNameException extends Exception{
    public BadFileNameException(String errorMessage) {
        super(errorMessage);
    }
}
