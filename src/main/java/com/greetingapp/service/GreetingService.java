package com.greetingapp.service;

import com.greetingapp.model.Greeting;
import com.greetingapp.dto.User;

import java.util.List;

public interface GreetingService {
    Greeting addGreeting(User user);

    Greeting getGreeting(long id);

    void deleteGreeting(long id);

    List<Greeting> getALlGreeting();

    Greeting updateGreeting(long id, String message);
}
