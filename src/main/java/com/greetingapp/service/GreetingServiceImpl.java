package com.greetingapp.service;


import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {


    @Override
    public String getGreeting(String... name) {
        if (name.length == 1) {
            return "Hello " + name[0];
        }
        if (name.length == 2)
            return "Hello " + name[0] + " " + name[1];
        return "Hello World";
    }
}
