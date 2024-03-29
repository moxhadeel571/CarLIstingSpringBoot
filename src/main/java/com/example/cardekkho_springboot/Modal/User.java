package com.example.cardekkho_springboot.Modal;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Document(collection = "users")
public class User {
    @MongoId
    private ObjectId id;
    private String fullName; // Corrected variable name to follow Java conventions
    private String gender;
    private String confirmPass; // Corrected variable name to follow Java conventions
    private String mobileNo; // Corrected variable name to follow Java conventions
    private String password;
    private String email;
    private String[] roles;


//    public <R> User(String email, String password, R collect) {
//    }
}
