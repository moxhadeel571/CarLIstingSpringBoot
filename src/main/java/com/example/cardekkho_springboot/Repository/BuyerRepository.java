package com.example.cardekkho_springboot.Repository;

import com.example.cardekkho_springboot.Modal.Buyer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends MongoRepository< Buyer, ObjectId> {
}
