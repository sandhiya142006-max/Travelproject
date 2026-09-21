package com.travel.travelproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
private final UserRepository userRepository;
private final PasswordEncoder passwordEncoder;

public HomeController(UserRepository userRepository,
                      PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
}
    @GetMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
public String loginUser(
        @RequestParam String email,
        @RequestParam String password) {

    User user = userRepository.findByEmail(email).orElse(null);

    if (user != null && passwordEncoder.matches(password, user.getPassword())) {
        return "redirect:/home";
    }

    return "redirect:/login?error=true";
}
@GetMapping("/register")
public String register() {
    return "register";
}
@PostMapping("/register")
public String registerUser(
        @RequestParam String email,
        @RequestParam String password) {

    if (userRepository.findByEmail(email).isPresent()) {
        return "redirect:/register?error=exists";
    }

    User user = new User();
    user.setEmail(email);
    user.setPassword(passwordEncoder.encode(password));

    userRepository.save(user);

    return "redirect:/login?registered=true";
}
  @GetMapping("/home")
public String homePage() {
    return "home";
}
@GetMapping("/destinations")
public String destinations() {
    return "explore-destinations";
}
    @GetMapping("/planner")
    public String planner() {
        return "planner";
    }
@GetMapping("/weather")
public String weather() {
    return "travel-weather";
}
@GetMapping("/toolkit")
public String toolkit() {
    return "travel-toolkit";
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
        model.addAttribute("stayBudget", budget * 0.35);
model.addAttribute("foodBudget", budget * 0.20);
model.addAttribute("transportBudget", budget * 0.20);
model.addAttribute("activityBudget", budget * 0.15);
model.addAttribute("emergencyBudget", budget * 0.10);
        return "trip-result";
    }
@GetMapping("/itinerary")
public String itinerary(
        @RequestParam(required = false, defaultValue = "Kodaikanal") String destination,
        @RequestParam(required = false, defaultValue = "1") int days,
        @RequestParam(required = false, defaultValue = "Solo") String mood,
        Model model) {

    if (destination.equalsIgnoreCase("kodaikanal")) {
        destination = "Kodaikanal";
    } else if (destination.equalsIgnoreCase("ooty")) {
        destination = "Ooty";
    } else if (destination.equalsIgnoreCase("munnar")) {
        destination = "Munnar";
    } else if (destination.equalsIgnoreCase("manali")) {
        destination = "Manali";
    }

    List<Map<String, String>> itineraryDays = new ArrayList<>();

    String[] places;

    if (destination.equalsIgnoreCase("Manali")) {

        places = new String[] {
            "Mall Road & Manali Town",
            "Solang Valley",
            "Old Manali",
            "Hadimba Temple",
            "Vashisht Hot Springs",
            "Atal Tunnel",
            "Sissu Valley",
            "Manali Nature Walk",
            "Local Shopping & Cafés",
            "Farewell Mountain Evening"
        };

    } else if (destination.equalsIgnoreCase("Ooty")) {

        places = new String[] {
            "Ooty Lake",
            "Botanical Garden",
            "Doddabetta Peak",
            "Rose Garden",
            "Coonoor",
            "Tea Factory",
            "Pykara Lake",
            "Pykara Waterfalls",
            "Emerald Lake",
            "Ooty Town & Shopping"
        };

    } else if (destination.equalsIgnoreCase("Munnar")) {

        places = new String[] {
            "Munnar Town",
            "Tea Gardens",
            "Mattupetty Dam",
            "Echo Point",
            "Kundala Lake",
            "Top Station",
            "Tea Museum",
            "Attukad Waterfalls",
            "Eravikulam National Park",
            "Munnar Local Shopping"
        };

    } else {

        places = new String[] {
            "Welcome & Local Exploration",
            "Popular Tourist Attractions",
            "Local Culture & Food",
            "Nature & Scenic Views",
            "Famous Landmarks",
            "Adventure & Outdoor Activities",
            "Local Markets",
            "Hidden Gems",
            "Relaxation & Photography",
            "Farewell & Memories"
        };
    }

    for (int i = 0; i < days; i++) {

        Map<String, String> dayPlan = new HashMap<>();

        String place = places[i % places.length];
        String famousPlace = place;
        dayPlan.put("day", String.valueOf(i + 1));
        dayPlan.put("title", place);
        dayPlan.put("famousPlace", famousPlace);
        dayPlan.put(
            "description",
            "Discover " + place + " and enjoy a memorable "
            + mood.toLowerCase() + " travel experience in "
            + destination + "."
        );

        String activity;

        if (mood.equalsIgnoreCase("Couple")) {
            activity = "Enjoy " + place
                    + " together, take photos, enjoy the views and spend quality time.";
        } else if (mood.equalsIgnoreCase("Friends")) {
            activity = "Have fun with friends at " + place
                    + " and enjoy activities, food and memorable moments.";
        } else if (mood.equalsIgnoreCase("Family")) {
            activity = "Explore " + place
                    + " with family and enjoy comfortable sightseeing and local experiences.";
        } else if (mood.equalsIgnoreCase("Adventure")) {
            activity = "Experience outdoor activities around " + place
                    + " and enjoy an exciting adventure.";
        } else if (mood.equalsIgnoreCase("Relax")) {
            activity = "Relax around " + place
                    + ", enjoy the peaceful surroundings and take things at a comfortable pace.";
        } else if (mood.equalsIgnoreCase("Nature")) {
            activity = "Explore the natural beauty around " + place
                    + " and enjoy scenic views and fresh surroundings.";
        } else {
            activity = "Explore " + place
                    + ", try local food and enjoy the unique experiences of " + destination + ".";
        }

        dayPlan.put("activity", activity);

        itineraryDays.add(dayPlan);
    }

    model.addAttribute("destination", destination);
    model.addAttribute("days", days);
    model.addAttribute("mood", mood);
    model.addAttribute("itineraryDays", itineraryDays);

    return "itinerary";
}
}