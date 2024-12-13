package io.runner.runner;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {
    public  String getWelcomeMeggase ()
    {
        return "Welcome to the spring boot application";
    }
}
