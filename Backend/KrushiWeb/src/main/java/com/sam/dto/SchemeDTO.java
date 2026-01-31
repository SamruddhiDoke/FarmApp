package com.sam.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchemeDTO {

    private Long id;
    private String title;
    private String shortDescription;
    private String category;
    private String state;
    private String officialUrl;
    private String applyUrl;
}
