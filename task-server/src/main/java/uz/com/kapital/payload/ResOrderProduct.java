package uz.com.kapital.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResOrderProduct {
    private Integer id;
    private Date date;
    private Integer customerId;
    private String productName;
}
