package com.greetingapp.model;

public class Greeting {

    private final long counter;
    private final String message;

    public Greeting(long counter, String message) {
        this.counter = counter;
        this.message = message;
    }

    public long getCounter() {
        return counter;
    }

    public String getMessage() {
        return message;
    }
}
