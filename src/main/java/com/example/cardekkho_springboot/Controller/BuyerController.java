package com.example.cardekkho_springboot.Controller;

import com.example.cardekkho_springboot.Modal.Seller;
import com.example.cardekkho_springboot.Service.BUyerServce;
import com.example.cardekkho_springboot.Service.SellerService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@RequestMapping("/Buyer")
@Controller
public class BuyerController {
    public static final String ACCOUNT_SID = "AC2315bcf242f15566da8033df4c5da5d2";
    public static final String AUTH_TOKEN = "afd5a064161e210056d8099f90435ce8";
    private static final List<String> CAR_NAMES = Arrays.asList(
            "Maruti Suzuki Alto",
            "Maruti Suzuki Baleno",
            "Maruti Suzuki Celerio",
            "Maruti Suzuki Dzire",
            "Maruti Suzuki Ertiga",
            "Maruti Suzuki Ignis",
            "Maruti Suzuki S-Cross",
            "Maruti Suzuki Swift",
            "Maruti Suzuki Vitara Brezza",
            "Maruti Suzuki Wagon R",
            "Hyundai Grand i10",
            "Hyundai i20",
            "Hyundai Venue",
            "Hyundai Creta",
            "Hyundai Verna",
            "Hyundai Aura",
            "Hyundai Kona Electric",
            "Tata Altroz",
            "Tata Harrier",
            "Tata Nexon",
            "Tata Tiago",
            "Tata Tigor",
            "Tata Safari",
            "Mahindra Thar",
            "Mahindra Scorpio",
            "Mahindra XUV300",
            "Mahindra XUV500",
            "Mahindra Bolero",
            "Mahindra KUV100",
            "Honda Amaze",
            "Honda City",
            "Honda WR-V",
            "Honda Jazz",
            "Ford EcoSport",
            "Ford Figo",
            "Ford Freestyle",
            "Ford Aspire",
            "Volkswagen Polo",
            "Volkswagen Vento",
            "Volkswagen T-Roc",
            "Volkswagen Tiguan Allspace",
            "Toyota Glanza",
            "Toyota Innova Crysta",
            "Toyota Fortuner",
            "Toyota Urban Cruiser",
            "Renault Kwid",
            "Renault Triber",
            "Renault Duster",
            "Nissan Magnite",
            "Nissan Kicks",
            "Nissan Terrano",
            "MG Hector",
            "MG ZS EV",
            "MG Gloster",
            "Kia Seltos",
            "Kia Sonet",
            "Kia Carnival",
            "Fiat Linea",
            "Fiat Avventura",
            "Fiat Urban Cross",
            "Jeep Compass",
            "Jeep Wrangler",
            "Jeep Grand Cherokee",
            "Datsun redi-GO",
            "Datsun GO",
            "Audi A3",
            "Audi A4",
            "Audi A6",
            "Audi Q3",
            "Audi Q5",
            "Audi Q7",
            "BMW 3 Series",
            "BMW 5 Series",
            "BMW X1",
            "BMW X3",
            "BMW X5",
            "Mercedes-Benz A-Class",
            "Mercedes-Benz C-Class",
            "Mercedes-Benz E-Class",
            "Mercedes-Benz GLA",
            "Mercedes-Benz GLC",
            "Mercedes-Benz GLE",
            "Jaguar XE",
            "Jaguar XF",
            "Jaguar F-PACE",
            "Volvo S60",
            "Volvo XC40",
            "Volvo XC60",
            "Volvo XC90",
            "Skoda Rapid",
            "Skoda Superb",
            "Skoda Karoq",
            "Skoda Kodiaq",
            "Land Rover Discovery Sport",
            "Land Rover Range Rover Evoque",
            "Land Rover Range Rover Velar",
            "Land Rover Range Rover",
            "Toyota Camry",
            "Ford Endeavour",
            "Nissan Sunny",
            "Renault Kiger",
            "MG Astor"
    );
private BUyerServce bUyerServce;
private SellerService sellerService;

@Autowired
    public BuyerController(  BUyerServce bUyerServce, SellerService sellerService) {
    this.bUyerServce = bUyerServce;
    this.sellerService = sellerService;
}

    @GetMapping("/BuyCar")
    public String getBuyCar(Model model) {
        List<Seller> sellers = sellerService.findAll();
        model.addAttribute("sellers", sellers);
        model.addAttribute("carNames", CAR_NAMES);
        return "BuyCar";
    }

    @ResponseBody
    @GetMapping("/getCarNames")
    public List<String> getCarNames() {
        return CAR_NAMES;
    }

    @GetMapping("/View_Car/{id}")
    public String GetView_Car(Model model, @PathVariable("id")ObjectId id){
        Optional<Seller> cars = sellerService.findByID(id);
        model.addAttribute("sellers",cars.orElse(null));
        return "BuyerView";
    }

    @GetMapping(value = "/sendSMS")
    public String sendSMS() {

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Twilio.setUsername(ACCOUNT_SID);
        Twilio.setPassword(AUTH_TOKEN);

        Message.creator(
                new PhoneNumber("+916304324592"), new PhoneNumber("+13155875258"),
                "\"Hi,\n" +
                        "\n" +
                        "Interested in your car listing! Can you provide more details about the vehicle? Condition, maintenance, and any extras?\n" +
                        "\n" +
                        "Thanks!\""
        ).create();

        return "redirect:/Buyer/BuyCar";
    }

}

