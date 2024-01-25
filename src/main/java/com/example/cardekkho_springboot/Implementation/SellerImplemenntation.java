package com.example.cardekkho_springboot.Implementation;

import com.example.cardekkho_springboot.Modal.Seller;
import com.example.cardekkho_springboot.Repository.SellerRepository;
import com.example.cardekkho_springboot.Service.SellerService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SellerImplemenntation implements SellerService {
    private SellerRepository sellerRepository;
@Autowired
    public SellerImplemenntation(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }
    @Override
    public void updateSeller(Seller seller, MultipartFile[] files) {
        // Check if there are new images to upload
        if (files != null && files.length > 0) {
            List<Seller.Images> newImagesList = new ArrayList<>();

            for (MultipartFile file : files) {
                Seller.Images image = new Seller.Images();
                try {
                    image.setFileDAta(file.getBytes());
                    image.setFileName(file.getOriginalFilename());
                    image.setContentType(file.getContentType());
                } catch (IOException e) {
                    e.printStackTrace(); // Handle the exception appropriately
                }
                newImagesList.add(image);
            }

            // Set the new images to the seller
            seller.getPhotos().addAll(newImagesList);
        }

        // Save the updated seller information
        sellerRepository.save(seller);
    }

    @Override
    public void save(Seller seller, MultipartFile[] files) {
        List<Seller.Images> imagesList = new ArrayList<>();

        for (MultipartFile file : files) {
            Seller.Images image = new Seller.Images();
            try {
                image.setFileDAta(file.getBytes());
                image.setFileName(file.getOriginalFilename());
                image.setContentType(file.getContentType());
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
            imagesList.add(image);
        }

        seller.setPhotos(imagesList);
        sellerRepository.save(seller);
    }

    @Override
    public List<Seller> findAll() {
        return sellerRepository.findAll();
    }
@Override
    public Optional<Seller> findByID(ObjectId productId) {
        return sellerRepository.findById(productId);
    }

    @Override
    public void deleteByID(ObjectId id) {
        sellerRepository.deleteById(id);
    }

    @Override
    public void getApproval(ObjectId id) {
        Optional<Seller> optionalSeller = sellerRepository.findById(id);
        if (optionalSeller.isPresent()) {
            Seller seller = optionalSeller.get();
            seller.setStatus("Approved");

            // Save the updated seller back to the repository
            sellerRepository.save(seller);
        } else {
            // Handle the case where the seller with the given id is not found
            // You can throw an exception, log a message, or handle it according to your application's requirements
        }
    }

    @Override
    public void getDisapproval(ObjectId id) {
        Optional<Seller> optionalSeller = sellerRepository.findById(id);
        if (optionalSeller.isPresent()) {
            Seller seller = optionalSeller.get();
            seller.setStatus("Disapproved");

            // Save the updated seller back to the repository
            sellerRepository.save(seller);
        } else {
            // Handle the case where the seller with the given id is not found
            // You can throw an exception, log a message, or handle it according to your application's requirements
        }
    }


}
