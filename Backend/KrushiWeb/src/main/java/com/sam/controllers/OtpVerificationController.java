package com.sam.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sam.services.OtpVerificationService;

@RestController
@RequestMapping("/api/v1/otp")
@CrossOrigin("*")
public class OtpVerificationController
{
    @Autowired
    private OtpVerificationService otpService;

    // ================= SEND OTP =================
    @PostMapping("/send")
    public ResponseEntity<?> sendOtp(@RequestParam String email)
    {
        otpService.generateAndSendOtp(email);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "OTP sent to email");
        return ResponseEntity.ok(response);
    }

    // ================= VERIFY OTP =================
    @PostMapping("/verify")
    public ResponseEntity<?> verifyOtp(
            @RequestParam String email,
            @RequestParam String otp)
    {
        boolean verified = otpService.verifyOtp(email, otp);

        Map<String, Object> response = new HashMap<>();

        if (verified) {
            response.put("message", "OTP verified successfully");
            response.put("verified", true);
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid or expired OTP");
            response.put("verified", false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
