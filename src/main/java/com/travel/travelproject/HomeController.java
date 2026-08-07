package com.travel.travelproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/planner")
    public String planner() {
        return "planner";
    }

    @GetMapping("/trip-result")
    public String tripResult(
            @RequestParam String destination,
            @RequestParam int days,
            @RequestParam double budget,
            @RequestParam String mood,
            Model model) {

        model.addAttribute("destination", destination);
        model.addAttribute("days", days);
        model.addAttribute("budget", budget);
        model.addAttribute("mood", mood);

        return "trip-result";
    }
   @GetMapping("/itinerary")
public String itinerary(@RequestParam int days, Model model) {
    model.addAttribute("days", days);
    return "itinerary";
}
}