package com.greetingapp.controller;

import com.greetingapp.model.Greeting;
import com.greetingapp.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetingcontroller")
public class GreetingController {
    private static final String template = "Hello %s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/home")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/greeting/{name}")
    public Greeting greetingGet(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PostMapping("/post")
    public Greeting greetingPost(@RequestBody User user) {
        return new Greeting(counter.incrementAndGet(), String.format(template, user.getName()));
    }

    @PutMapping("/put")
    public Greeting greetingPut(@RequestParam(value = "name") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
