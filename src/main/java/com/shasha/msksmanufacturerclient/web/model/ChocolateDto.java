package com.shasha.msksmanufacturerclient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChocolateDto {

    private UUID id;
    private String chocolateName;
    private String chocolateSlogan;
    private String chocolateType;
    private Long upc;

}
