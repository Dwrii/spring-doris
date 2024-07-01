package com.example.springdoris.Controller;

import com.example.springdoris.model.DorisApp;
import com.example.springdoris.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DorisController {

    private int indexDorisApp = 0;
    private int indexUserMap = 0;
    private Map<Integer, DorisApp> dorisAppMap = new HashMap<>();
    private Map<Integer, User> userMap= new HashMap<>();

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/user/{index}")
    public String getUser(@PathVariable int index) {
        User user = userMap.get(index);
        if (user == null) {
            return "User not found";
        }
        return user.getFirstName() + " , " + user.getLastName();
    }

    @GetMapping("/firstName/{index}")
    public String getFirstName(@PathVariable int index) {
        User user = userMap.get(index);
        if (user == null) {
            return "User not found";
        }
        return user.getFirstName();
    }

    @GetMapping("/lastName/{index}")
    public String getLastName(@PathVariable int index) {
        User user = userMap.get(index);
        if (user == null) {
            return "User not found";
        }
        return user.getLastName();
    }

    @GetMapping("/dorisApp/{index}")
    public DorisApp getDorisApp(@PathVariable int index) {
        DorisApp dorisApp = dorisAppMap.get(index);
        if (dorisApp == null) {
            return null;
        }
        return dorisApp;
    }

    @PostMapping("/makeDorisApp")
    public String postDorisApp(@RequestBody User user) {

        userMap.put(indexUserMap, user);
        DorisApp current = new DorisApp(user);
        dorisAppMap.put(indexDorisApp, current);
        ++indexUserMap;
        ++indexDorisApp;
        return "A New App is Added";
    }

    @PostMapping("/makeUser")
    public String postUser(@RequestParam(value = "firstName", defaultValue = "frist") String firstName,
                         @RequestParam(value = "lastName", defaultValue = "last") String lastName){
        User current =  new User(firstName, lastName);
        userMap.put(indexUserMap, current);
        ++indexUserMap;
        return "A New User is Added: " + current.firstName + ", " + current.lastName;
    }
}
