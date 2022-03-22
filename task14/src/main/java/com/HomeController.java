package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/home")
    public String get(){
        return "index.html";
        //return "<html>\n<body>\n<span>Artyukhin</span>\n<span>Daniil</span>\n<span>IKBO-01</span>\n</body>";
    }
}
