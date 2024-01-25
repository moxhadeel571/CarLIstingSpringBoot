package com.example.cardekkho_springboot.Repository;

import com.example.cardekkho_springboot.Modal.Admin;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<Admin, ObjectId> {
}
