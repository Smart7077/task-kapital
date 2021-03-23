package uz.com.kapital.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResProduct {
    private Integer id;
    private String name;
    private Integer categoryId;
    private String description;
    private Double price;
    private String photo;
}
