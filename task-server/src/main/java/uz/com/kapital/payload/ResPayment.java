package uz.com.kapital.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResPayment {
    private Integer id;
    private Timestamp time;
    private Double amount;
    private Integer invoiceId;
}
