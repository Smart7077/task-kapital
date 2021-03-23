package uz.com.kapital.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResCustomerMax {
    private Integer id;
    private String name;
    private String country;
    private String address;
    private String phone;
    private Date date;
}
