package uz.com.kapital.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResCustomer {
    private Integer id;
    private String name;
    private String country;
    private String address;
    private String phone;
}
