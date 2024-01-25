package com.example.cardekkho_springboot.Modal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Buyer {

@GetMapping("/Buy-Car")
    public String GetBuyer(){

    return "Buyer";
}

}
