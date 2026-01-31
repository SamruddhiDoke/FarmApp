package com.sam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sam.dto.SchemeDTO;
import com.sam.models.Scheme;
import com.sam.services.SchemeService;

@RestController
@RequestMapping("/api/v1/schemes")
@CrossOrigin("*")
public class SchemeController {

    @Autowired
    private SchemeService schemeService;

    // 🔹 Get latest schemes
    @GetMapping("/latest")
    public ResponseEntity<List<SchemeDTO>> getLatestSchemes(
            @RequestParam(required = false) String state) {

        return ResponseEntity.ok(schemeService.getLatestSchemes(state));
    }

    // 🔹 Get full scheme details
    @GetMapping("/{id}")
    public ResponseEntity<Scheme> getSchemeDetails(@PathVariable Long id) {
        return ResponseEntity.ok(schemeService.getSchemeById(id));
    }
}
