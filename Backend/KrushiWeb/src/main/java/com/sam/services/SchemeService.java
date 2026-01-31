package com.sam.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.dto.SchemeDTO;
import com.sam.models.Scheme;
import com.sam.repositories.SchemeRepository;

@Service
public class SchemeService {

    @Autowired
    private SchemeRepository schemeRepository;

    // Latest 8–9 schemes (state-based fallback)
    public List<SchemeDTO> getLatestSchemes(String state) {

        List<Scheme> schemes;

        if (state != null && !state.isBlank()) {
            schemes = schemeRepository
                    .findTop9ByStateAndActiveTrueOrderByUpdatedAtDesc(state.toUpperCase());

            if (schemes.isEmpty()) {
                schemes = schemeRepository.findTop9ByActiveTrueOrderByUpdatedAtDesc();
            }
        } else {
            schemes = schemeRepository.findTop9ByActiveTrueOrderByUpdatedAtDesc();
        }

        return schemes.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get scheme details
    public Scheme getSchemeById(Long id) {
        return schemeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Scheme not found"));
    }

    private SchemeDTO convertToDTO(Scheme scheme) {
        return new SchemeDTO(
                scheme.getId(),
                scheme.getTitle(),
                scheme.getShortDescription(),
                scheme.getCategory(),
                scheme.getState(),
                scheme.getOfficialUrl(),
                scheme.getApplyUrl()
        );
    }
}
