package com.greetingapp.controller;

import com.greetingapp.model.Greeting;
import com.greetingapp.dto.User;
import com.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetingcontroller")
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingService greetingService;

    @GetMapping("/greeting/{id}")
    public Greeting greetingGet(@PathVariable long id) {
        return greetingService.getGreeting(id);
    }

    @PostMapping("/post")
    public Greeting greetingPost(@RequestBody User user) {
        return greetingService.addGreeting(user);
    }

    @PutMapping("/updateGreeting/{id}")
    public Greeting greetingPut(@PathVariable long id, @RequestParam(value = "message") String message) {
        return greetingService.updateGreeting(id,message);
    }

    @RequestMapping("/allgreetings")
    public List<Greeting> greetingList() {
        return greetingService.getALlGreeting();
    }

    @RequestMapping("/deleteGreeting/{id}")
    public void deleteGreeting(@PathVariable long id){
        greetingService.deleteGreeting(id);
    }
}
