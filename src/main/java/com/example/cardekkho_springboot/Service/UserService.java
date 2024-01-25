package com.example.cardekkho_springboot.Service;

import com.example.cardekkho_springboot.Modal.User;
import org.springframework.stereotype.Service;


@Service
public interface UserService {



 User saveUser(User User);

 public void removeSuccessMessage();

}