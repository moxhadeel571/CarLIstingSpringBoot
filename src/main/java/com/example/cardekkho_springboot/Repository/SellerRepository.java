package com.example.cardekkho_springboot.Repository;

import com.example.cardekkho_springboot.Modal.Seller;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends MongoRepository< Seller,ObjectId>{
}
