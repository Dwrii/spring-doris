package com.example.springdoris.model;

import org.springframework.stereotype.Component;
import com.example.springdoris.model.User;

@Component
public class DorisApp {
    public User user;

    public DorisApp(){
    }

    public DorisApp(User user){
       this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
