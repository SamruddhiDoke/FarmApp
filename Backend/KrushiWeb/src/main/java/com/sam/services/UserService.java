package com.sam.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sam.models.User;
import com.sam.repositories.UserRepository;
import com.sam.responseWrapper.MyResponseWrapper;

@Service
public class UserService 
{
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private OtpVerificationService otpVerificationService;

    
    public ResponseEntity<?> register(User user)
    {
        MyResponseWrapper responseWrapper = new MyResponseWrapper(); 
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());

        if(existingUser.isPresent())
        {
            responseWrapper.setMessage("Email already exists");
            responseWrapper.setData(null);
            return new ResponseEntity<>(responseWrapper, HttpStatus.CONFLICT);
        }

        user.setVerified(false);   // 🔥 IMPORTANT
        User savedUser = userRepository.save(user);

        // Call OTP generation
        otpVerificationService.generateAndSendOtp(user.getEmail());

        responseWrapper.setMessage("Registration successful. OTP sent to email.");
        responseWrapper.setData(savedUser);
        return new ResponseEntity<>(responseWrapper, HttpStatus.CREATED);
    }

    
    public ResponseEntity<?> login(String email, String password)
    {
        MyResponseWrapper responseWrapper = new MyResponseWrapper(); 
        Optional<User> userOpt = userRepository.findByEmailAndPassword(email, password);

        if(userOpt.isEmpty())
        {
            responseWrapper.setMessage("Wrong credentials");
            responseWrapper.setData(null);
            return new ResponseEntity<>(responseWrapper, HttpStatus.NOT_FOUND);
        }

        User user = userOpt.get();

        // 🔥 OTP CHECK
        if(!user.isVerified())
        {
            responseWrapper.setMessage("Please verify OTP before login");
            responseWrapper.setData(null);
            return new ResponseEntity<>(responseWrapper, HttpStatus.UNAUTHORIZED);
        }

        responseWrapper.setMessage("Login Success!");
        responseWrapper.setData(user);
        return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
    }

}

