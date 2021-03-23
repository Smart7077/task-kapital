package uz.com.kapital.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResInvoiceOrder {
    private Integer id;
    private Date issued;
    private Integer orderId;
    private Date orderDate;
}
