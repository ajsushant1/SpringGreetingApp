package com.greetingapp.controller;

import com.greetingapp.model.Greeting;
import com.greetingapp.model.User;
import com.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetingcontroller")
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingService greetingService;

    @RequestMapping("/home")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), greetingService.getGreeting(name));
    }

    @GetMapping("/greeting/{firstName}/{lastName}")
    public Greeting greetingGet(@PathVariable String firstName, @PathVariable String lastName) {
        return new Greeting(counter.incrementAndGet(), greetingService.getGreeting(firstName, lastName));
    }

    @PostMapping("/post")
    public Greeting greetingPost(@RequestBody User user) {
        return new Greeting(counter.incrementAndGet(), greetingService.getGreeting(user.getFirstName(), user.getLastName()));
    }

    @PutMapping("/put/{firstName}")
    public Greeting greetingPut(@PathVariable String firstName, @RequestParam(value = "lastName") String lastName) {
        return new Greeting(counter.incrementAndGet(), greetingService.getGreeting(firstName, lastName));
    }

    @RequestMapping("/greeting")
    public String greeting() {
        return greetingService.getGreeting();
    }
}
