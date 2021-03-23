package uz.com.kapital.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqOrderDetail {
    private Integer customer_id;
    private Integer product_id;
    private Integer quantity;
}
