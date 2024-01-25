package com.example.cardekkho_springboot.Modal;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Document(collection = "Seller")
public class Seller {
    @MongoId
    private ObjectId id;
    private String Sellername;
    private String SellerNumber;
    private String CarRegistrationNumber;
    private String CarBrand;
    private String RegistrationYear;
    private String CarModelName;
    private String Car_variant;
    private String CarOwnerShip;
    private String KMDriven;
    private String StateLocation;
    private Double CarPrice;
    private String status;
    private String Description;
    private List<Images> photos;
    public List<Images> getPhotos() {
        if (photos == null) {
            photos = new ArrayList<>();
        }
        return photos;
    }
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Images{

        private byte[] FileDAta;
        private String FileName;
        private String ContentType;


    }




}
