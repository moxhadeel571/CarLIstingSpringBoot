package com.example.cardekkho_springboot.Service;

import com.example.cardekkho_springboot.Modal.Seller;
import org.bson.types.ObjectId;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface SellerService {
    void updateSeller(Seller seller, MultipartFile[] files);

    void save(Seller seller, MultipartFile[] files);

    List<Seller> findAll();


    Optional<Seller> findByID(ObjectId productId);

    void deleteByID(ObjectId id);


    void getApproval(ObjectId id);

    void getDisapproval(ObjectId id);
}
