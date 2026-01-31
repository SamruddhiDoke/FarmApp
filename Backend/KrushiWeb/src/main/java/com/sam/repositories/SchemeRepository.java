package com.sam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.models.Scheme;

@Repository
public interface SchemeRepository extends JpaRepository<Scheme, Long> {

    List<Scheme> findTop9ByActiveTrueOrderByUpdatedAtDesc();

    List<Scheme> findTop9ByStateAndActiveTrueOrderByUpdatedAtDesc(String state);

    List<Scheme> findByCategoryAndActiveTrue(String category);
}
