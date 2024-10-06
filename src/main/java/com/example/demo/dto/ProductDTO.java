package com.example.demo.dto;

import java.util.List;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProductDTO {
    private String name;
    private Float price;
    private Float rating;
    private String description;
    private Float discountPercentage;
    private List<String> productImages;

}
