package uz.com.kapital.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResInvoice {
    private Integer id;
    private Integer orderId;
    private Double amount;
    private Date issued;
    private Date due;
}
