package com.greetingapp.service;

import com.greetingapp.dto.GreetingDTO;
import com.greetingapp.dto.User;
import com.greetingapp.model.Greeting;
import com.greetingapp.repository.GreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingServiceImpl implements GreetingService {
    String template = "Hello %s";

    @Autowired
    GreetingRepository repository;

    ModelMapper modelMapper = new ModelMapper();

    //METHOD TO ADD GREETING IN REPOSITORY
    @Override
    public Greeting addGreeting(User user) {
        String message = (user.getFirstName().isEmpty() && user.getLastName().isEmpty()) ? String.format(template, "World") :
                (user.getFirstName().isEmpty()) ? String.format(template, user.getLastName()) :
                        (user.getLastName().isEmpty()) ? String.format(template, user.getFirstName()) :
                                String.format(template, user.getFirstName() + " " + user.getLastName());

        Greeting map = modelMapper.map(new GreetingDTO(message), Greeting.class);
        return repository.save(map);
    }

    //METHOD TO GET GREETING FROM REPOSITORY
    @Override
    public Greeting getGreeting(long id) {
        return repository.findById(id).get();
    }

    //METHOD TO DELETE GREETING FROM REPOSITORY
    @Override
    public void deleteGreeting(long id) {
        repository.deleteById(id);
    }

    //METHOD TO GET ALL GREETING FROM REPOSITORY
    @Override
    public List<Greeting> getALlGreeting() {
        return repository.findAll();
    }

    //METHOD TO UPDATE GREETING
    @Override
    public Greeting updateGreeting(long id, String message) {
        Greeting greeting = repository.findById(id).get();
        greeting.setMessage(message);
        return repository.save(greeting);
    }
}
