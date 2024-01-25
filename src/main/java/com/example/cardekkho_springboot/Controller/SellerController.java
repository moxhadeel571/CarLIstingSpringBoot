package com.example.cardekkho_springboot.Controller;

import com.example.cardekkho_springboot.Modal.Seller;
import com.example.cardekkho_springboot.Service.SellerService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@RequestMapping("/Seller")
@Controller
public class SellerController {
    private SellerService sellerService;
@Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }


    @GetMapping("/Sell-Car")
    public String getDashboard(){

    return "Seller";
}

@GetMapping("/form")
    public String GetForm(@ModelAttribute Seller seller,Model model){
    List<String> indianStates = Arrays.asList(
            "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh",
            "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand",
            "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur",
            "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab",
            "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura",
            "Uttar Pradesh", "Uttarakhand", "West Bengal"
    );

    model.addAttribute("state", indianStates);
    return "Form";
}


@GetMapping("/carlisting")
    public String Getcarlisting(Model model, @ModelAttribute Seller seller){
    List<Seller> sellers=sellerService.findAll();
    model.addAttribute("cars",sellers);
    return "Listing";
}
@PostMapping("/saveform")
    public String saveForm(@ModelAttribute Seller seller, @RequestParam("file")MultipartFile[] files){
    sellerService.save(seller,files);
    return "redirect:/Seller/Sell-Car";
}

    @GetMapping("/users/products/{productId}/image/{imageIndex}")
    public ResponseEntity<byte[]> getProductImage(
            @PathVariable ObjectId productId,
            @PathVariable int imageIndex) {
        Optional<Seller> product = sellerService.findByID(productId);

        List<  Seller.Images> images = product.get().getPhotos();
        if (imageIndex < 0 || imageIndex >= images.size()) {
            return ResponseEntity.notFound().build();
        }

        Seller.Images image = images.get(imageIndex);

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(image.getContentType()));

        return new ResponseEntity<>(image.getFileDAta(), headers, HttpStatus.OK);
    }
    @GetMapping("/view_car/{id}")
    public String getView(@PathVariable("id") ObjectId id, Model model) {
        Optional<Seller> cars = sellerService.findByID(id);
        model.addAttribute("idss",id);
        model.addAttribute("info", cars.orElse(null)); // Use orElse to handle the case where Seller is not found
        return "View";
    }

    @GetMapping("/products/{productId}/images/{imageIndex}")
    public ResponseEntity<byte[]> getProductImages(
            @PathVariable ObjectId productId,
            @PathVariable int imageIndex) {
        Optional<Seller> productOptional = sellerService.findByID(productId);

        if (productOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Seller product = productOptional.get();
        List<Seller.Images> images = product.getPhotos();

        if (imageIndex < 0 || imageIndex >= images.size()) {
            return ResponseEntity.notFound().build();
        }

        Seller.Images image = images.get(imageIndex);

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(image.getContentType()));

        return new ResponseEntity<>(image.getFileDAta(), headers, HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public String GetDelete(@PathVariable("id") ObjectId id){
    sellerService.deleteByID(id);
    return "redirect:/Seller/carlisting";
    }
    @PostMapping("/Edit/{id}")
    public String GetEditSave(@PathVariable("id") ObjectId id,@ModelAttribute Seller seller, @RequestParam("file")MultipartFile[] files){
    sellerService.updateSeller(seller,files);

        return "redirect:/carlisting";
    }
    @GetMapping("/edit/{id}")
    public String GetEdit(@PathVariable("id") ObjectId id,Model model,@ModelAttribute Seller seller){
    model.addAttribute("id",id);
        List<String> indianStates = Arrays.asList(
                "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh",
                "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand",
                "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur",
                "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab",
                "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura",
                "Uttar Pradesh", "Uttarakhand", "West Bengal"
        );

        model.addAttribute("state", indianStates);
        return "update";
    }
    }


