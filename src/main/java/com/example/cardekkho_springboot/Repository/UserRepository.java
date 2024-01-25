package com.example.cardekkho_springboot.Repository;

import com.example.cardekkho_springboot.Modal.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findFirstByEmail(String email);


}