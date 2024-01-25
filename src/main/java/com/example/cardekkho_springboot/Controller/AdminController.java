package com.example.cardekkho_springboot.Controller;

import com.example.cardekkho_springboot.Modal.Seller;
import com.example.cardekkho_springboot.Service.AdminService;
import com.example.cardekkho_springboot.Service.SellerService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
@RequestMapping("/Admin")
@Controller
public class AdminController {

private AdminService adminService;
private SellerService sellerService;

@Autowired
    public AdminController(AdminService adminService, SellerService sellerService) {
        this.adminService = adminService;
    this.sellerService = sellerService;
}
    @GetMapping("/admin")
    public String GetADmin(Model model){
        List<Seller> sellers= sellerService.findAll();
        model.addAttribute("sellers",sellers);
        return "Admin";
    }
    @GetMapping("/admit/products/{productId}/images/{imageIndex}")
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

    @GetMapping("/Approval/{id}")
    public String GetApproval(@PathVariable("id")ObjectId id){
    sellerService.getApproval(id);
        return "redirect:/Admin/admin";
    }
    @GetMapping("/Disapproval/{id}")
    public String Getdisapproval(@PathVariable("id")ObjectId id){
    sellerService.getDisapproval(id);
        return "redirect:/Admin/admin";
    }

}
